package com.dh.usersservice.configuration.feign;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.registration.ClientRegistration;

import java.util.Collection;

public class Oauth2ClientCredentialsFeignManager {

    private final OAuth2AuthorizedClientManager manager;
    private final ClientRegistration clientRegistration;
    private final Authentication principal;

    public Oauth2ClientCredentialsFeignManager(OAuth2AuthorizedClientManager manager,
                                               ClientRegistration clientRegistration) {
        this.manager = manager;
        this.clientRegistration = clientRegistration;
        this.principal = createPrincipal();

    }

    private Authentication createPrincipal() {
        return new Authentication() {
            @Override public Collection<? extends GrantedAuthority> getAuthorities() {return null;}
            @Override public Object getCredentials() {return null;}
            @Override public Object getDetails() {return null;}
            @Override public Object getPrincipal() {return this;}
            @Override public boolean isAuthenticated() {return false;}
            @Override public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {}
            @Override
            public String getName() {
                return clientRegistration.getClientId();
            }
        };
    }

    public String getAccessToken() {
        try {
            OAuth2AuthorizeRequest oAuth2AuthorizeRequest = OAuth2AuthorizeRequest
                    .withClientRegistrationId(clientRegistration.getClientId())
                    .principal(principal)
                    .build();

            OAuth2AuthorizedClient client = manager.authorize(oAuth2AuthorizeRequest);

            if (client == null) {
                throw new IllegalStateException(String.format(
                        "Client Credentials flow para registro %s falhou!!! o client não voltou", clientRegistration.getClientId()));
            }

            return client.getAccessToken().getTokenValue();

        }catch (Exception e) {
            System.out.println("Client Credentials com erro: " + e.getMessage());
        }
        return null;
    }
}
