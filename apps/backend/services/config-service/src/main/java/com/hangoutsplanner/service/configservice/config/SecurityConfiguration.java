package com.hangoutsplanner.service.configservice.config;

import com.hangoutsplanner.service.configservice.properties.SecurityProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
class SecurityConfiguration {

    /**
     * Password with encoder prefix (e.g. "{noop}...") added
     */
    private final SecurityProperties securityProperties;

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
            .username(securityProperties.getSpringSecurityUsername())
            .password(securityProperties.getSpringSecurityPassword())
            .roles("CONFIG_CLIENT")
            .build();
        return new InMemoryUserDetailsManager(configClientUser);
    }

}
