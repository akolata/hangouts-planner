package com.hangoutsplanner.service.hangoutsplannerbffservice.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.hangoutsplanner.service.hangoutsplannerbffservice.*")
class EnableFeignClientsConfiguration {
}
