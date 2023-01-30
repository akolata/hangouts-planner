package com.hangoutsplanner.service.configservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
class SecurityConfiguration {

    /**
     * Password with encoder prefix (e.g. "{noop}...") added
     */
    private final String configServiceSpringSecurityUserPassword;

    SecurityConfiguration(@Value("${CONFIG_SERVICE_SPRING_SECURITY_USER_PASSWORD}") String configServiceSpringSecurityUserPassword) {
        this.configServiceSpringSecurityUserPassword = configServiceSpringSecurityUserPassword;
    }

    @Bean
    public SecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/actuator/health/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.httpBasic();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager configure() {
        UserDetails configClientUser = User.builder()
            .username("config-client")
            .password(configServiceSpringSecurityUserPassword)
            .roles("CONFIG_CLIENT")
            .build();
        return new InMemoryUserDetailsManager(configClientUser);
    }

}
