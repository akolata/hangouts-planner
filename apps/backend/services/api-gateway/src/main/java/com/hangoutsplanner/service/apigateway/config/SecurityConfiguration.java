package com.hangoutsplanner.service.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http.cors();
        http.authorizeExchange(exchanges -> exchanges.anyExchange().authenticated())
//            .oauth2Login()
//            .authorizationEndpoint()
//            .baseUri("/oauth2/authorize")
//            .authorizationRequestRepository(cookieAuthorizationRequestRepository())
//            .and()
//            .redirectionEndpoint()
//            .baseUri("/oauth2/callback/*")
//            .and()
            .oauth2ResourceServer().jwt();
        http.csrf().disable();
        return http.build();
    }
}
