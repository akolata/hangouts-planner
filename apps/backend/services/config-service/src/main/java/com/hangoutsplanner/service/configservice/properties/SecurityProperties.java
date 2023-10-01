package com.hangoutsplanner.service.configservice.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ConfigurationProperties(prefix = "config-service.security")
public class SecurityProperties {

    /**
     * Secrets encryption key
     */
    @NotNull
    @NotEmpty
    private String encryptKey;

    @NotNull
    @NotEmpty
    private String springSecurityUsername;

    /**
     * Password with encoder prefix (e.g. "{noop}...") added
     */
    @NotNull
    @NotEmpty
    private String springSecurityPassword;
}
