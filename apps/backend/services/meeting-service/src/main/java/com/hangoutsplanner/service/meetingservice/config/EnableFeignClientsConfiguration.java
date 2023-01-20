package com.hangoutsplanner.service.meetingservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Configuration
@EnableFeignClients(basePackages = "com.hangoutsplanner.service.meetingservice.client")
class EnableFeignClientsConfiguration {
}
