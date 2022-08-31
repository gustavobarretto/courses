package com.digitalhouse.msgateway.configuration;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RealmRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Component
public class KeycloakInitializerRunner implements CommandLineRunner {

    private final Keycloak keycloakAdmin;

    @Override
    public void run(String... args) {
        log.info("Initializing '{}' realm in Keycloak ...", POST_SERVICE_REALM_NAME);

        Optional<RealmRepresentation> representationOptional = keycloakAdmin.realms()
                .findAll()
                .stream()
                .filter(r -> r.getRealm().equals(POST_SERVICE_REALM_NAME))
                .findAny();
        if (representationOptional.isPresent()) {
            log.info("Removing already pre-configured '{}' realm", POST_SERVICE_REALM_NAME);
            keycloakAdmin.realm(POST_SERVICE_REALM_NAME).remove();
        }

        // Realm
        RealmRepresentation realmRepresentation = new RealmRepresentation();
        realmRepresentation.setRealm(POST_SERVICE_REALM_NAME);
        realmRepresentation.setEnabled(true);
        realmRepresentation.setRegistrationAllowed(true);

        // Client
        ClientRepresentation clientRepresentation = new ClientRepresentation();
        clientRepresentation.setClientId(POST_APP);
        clientRepresentation.setDirectAccessGrantsEnabled(true);
        clientRepresentation.setPublicClient(true);
        clientRepresentation.setRedirectUris(Collections.singletonList(POSTS_APP_REDIRECT_URL));
        clientRepresentation.setDefaultRoles(new String[]{Roles.ADMIN.getROLE(), Roles.EDITOR.getROLE()});
        realmRepresentation.setClients(Collections.singletonList(clientRepresentation));

        // Users
        List<UserRepresentation> userRepresentations = POSTS_APP_USERS.stream()
                .map(userPass -> {
                    // User Credentials
                    CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
                    credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
                    credentialRepresentation.setValue(userPass.getPassword());

                    // User
                    UserRepresentation userRepresentation = new UserRepresentation();
                    userRepresentation.setUsername(userPass.getUsername());
                    userRepresentation.setEnabled(true);
                    userRepresentation.setCredentials(Collections.singletonList(credentialRepresentation));
                    userRepresentation.setClientRoles(getClientRoles(userPass));

                    return userRepresentation;
                })
                .collect(Collectors.toList());
        realmRepresentation.setUsers(userRepresentations);

        // Create Realm
        keycloakAdmin.realms().create(realmRepresentation);

        // Testing
        UserPass admin = POSTS_APP_USERS.get(0);
        log.info("Testing getting token for '{}' ...", admin.getUsername());

        Keycloak keycloakMovieApp = KeycloakBuilder.builder().serverUrl(KEYCLOAK_SERVER_URL)
                .realm(POST_SERVICE_REALM_NAME).username(admin.getUsername()).password(admin.getPassword())
                .clientId(POST_APP).build();

        log.info("'{}' token: {}", admin.getUsername(), keycloakMovieApp.tokenManager().grantToken().getToken());
        log.info("'{}' initialization completed successfully!", POST_SERVICE_REALM_NAME);
    }

    private Map<String, List<String>> getClientRoles(UserPass userPass) {
        List<String> roles = new ArrayList<>();
        roles.add(Roles.ADMIN.getROLE());
        roles.add(Roles.USER.getROLE());
        roles.add(Roles.EDITOR.getROLE());
        if ("admin".equals(userPass.getUsername())) {
            roles.add(Roles.ADMIN.getROLE());
        }
        return Map.of(POST_APP, roles);
    }

    private static final String KEYCLOAK_SERVER_URL = "http://localhost:8080";
    private static final String POST_SERVICE_REALM_NAME = "posts-service";
    private static final String POST_APP = "posts-app";
    private static final String POSTS_APP_REDIRECT_URL = "http://localhost:8082/*";
    private static final List<UserPass> POSTS_APP_USERS = Arrays.asList(
            new UserPass("admin", "admin"),
            new UserPass("user", "user"),
            new UserPass("editor", "editor")
    );

    @Value
    private static class UserPass {
        String username;
        String password;
    }
}
