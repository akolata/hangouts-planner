package com.hangoutsplanner.service.meetingservice.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.hangoutsplanner.service.meetingservice.client")
class EnableFeignClientsConfiguration {
}
