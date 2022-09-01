package com.example.msdiscovery.configuration;

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
        log.info("Initializing '{}' realm in Keycloak ...", BILLS_SERVICE_REALM_NAME);

        Optional<RealmRepresentation> representationOptional = keycloakAdmin.realms()
                .findAll()
                .stream()
                .filter(r -> r.getRealm().equals(BILLS_SERVICE_REALM_NAME))
                .findAny();
        if (representationOptional.isPresent()) {
            log.info("Removing already pre-configured '{}' realm", BILLS_SERVICE_REALM_NAME);
            keycloakAdmin.realm(BILLS_SERVICE_REALM_NAME).remove();
        }

        // Realm
        RealmRepresentation realmRepresentation = new RealmRepresentation();
        realmRepresentation.setRealm(BILLS_SERVICE_REALM_NAME);
        realmRepresentation.setEnabled(true);
        realmRepresentation.setRegistrationAllowed(true);

        // Client
        ClientRepresentation clientRepresentation = new ClientRepresentation();
        clientRepresentation.setClientId(BILLS_APP_ID);
        clientRepresentation.setDirectAccessGrantsEnabled(true);
        clientRepresentation.setPublicClient(false);
        clientRepresentation.setSecret(BILLS_CLIENT_SECRET);
        clientRepresentation.setRedirectUris(Collections.singletonList(BILLS_APP_REDIRECT_URL));
        clientRepresentation.setDefaultRoles(new String[]{USER});
        realmRepresentation.setClients(Collections.singletonList(clientRepresentation));

        // Users
        List<UserRepresentation> userRepresentations = BILLS_APP_USERS.stream()
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
        // Users created



        UserPass user = BILLS_APP_USERS.get(0);
        log.info("login in realm with this credentials '{}'", user.getUsername());
        log.info("username: {}", user.getUsername());
        log.info("password: {}", user.getPassword());

        log.info("Testing getting token for '{}' ...", user.getUsername());

        Keycloak keycloakBillsApp = KeycloakBuilder.builder()
                .serverUrl(KEYCLOAK_SERVER_URL)
                .realm(BILLS_SERVICE_REALM_NAME)
                .username(user.getUsername())
                .password(user.getPassword())
                .clientId(BILLS_APP_ID)
                .clientSecret(BILLS_CLIENT_SECRET)
                .build();

        log.info("'{}' token: {}", user.getUsername(), keycloakBillsApp
                .tokenManager()
                .grantToken()
                .getToken()
        );

        log.info("'{}' initialization completed successfully!", BILLS_SERVICE_REALM_NAME);
    }

    private Map<String, List<String>> getClientRoles(UserPass userPass) {
        List<String> roles = new ArrayList<>();
        roles.add(USER);
        return Map.of(BILLS_APP_ID, roles);
    }

    private static final String KEYCLOAK_SERVER_URL = "http://localhost:8080";
    private static final String BILLS_SERVICE_REALM_NAME = "bills-service";
    private static final String BILLS_APP_ID = "bills-app";
    private static final String BILLS_CLIENT_SECRET = "QEjznaJdw91A03iqFa7p8klE3PesLzad";
    private static final String BILLS_APP_REDIRECT_URL = "http://localhost:8090/*";
    private static final List<UserPass> BILLS_APP_USERS = Arrays.asList(
            new UserPass("admin", "admin"),
            new UserPass("user", "user")
    );

    @Value
    private static class UserPass {
        String username;
        String password;
    }

    private final String USER = "USER";
}
