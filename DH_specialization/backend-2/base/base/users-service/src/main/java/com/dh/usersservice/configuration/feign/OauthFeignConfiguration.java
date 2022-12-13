package com.dh.usersservice.configuration.feign;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@Configuration
public class OauthFeignConfiguration {
    private static final String KEYCLOAK_REGISTRATION_ID = "keycloak-registration";

    private final OAuth2AuthorizedClientService clientService;
    private final ClientRegistrationRepository registrationRepository;

    @Autowired
    public OauthFeignConfiguration(OAuth2AuthorizedClientService clientService, ClientRegistrationRepository registrationRepository) {
        this.clientService = clientService;
        this.registrationRepository = registrationRepository;
    }

    @Bean
    public RequestInterceptor requestInterceptors() {
        ClientRegistration clientRegistration = registrationRepository.findByRegistrationId(KEYCLOAK_REGISTRATION_ID);
        Oauth2ClientCredentialsFeignManager feignManager = new Oauth2ClientCredentialsFeignManager(auth2AuthorizedClientManager(), clientRegistration);

        return requestTemplate -> requestTemplate.header("Authorization", "Bearer " + feignManager.getAccessToken());

    }

    @Bean
    public OAuth2AuthorizedClientManager auth2AuthorizedClientManager() {
        OAuth2AuthorizedClientProvider auth2AuthorizedClientProvider = OAuth2AuthorizedClientProviderBuilder
                        .builder().clientCredentials().build();

        AuthorizedClientServiceOAuth2AuthorizedClientManager auth2AuthorizedClientManager =
                new AuthorizedClientServiceOAuth2AuthorizedClientManager(registrationRepository, clientService);

        auth2AuthorizedClientManager.setAuthorizedClientProvider(auth2AuthorizedClientProvider);
        return auth2AuthorizedClientManager;
    }
}
