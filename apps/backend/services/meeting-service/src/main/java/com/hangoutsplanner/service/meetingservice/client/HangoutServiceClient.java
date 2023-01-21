package com.hangoutsplanner.service.meetingservice.client;

import com.hangoutsplanner.service.meetingservice.config.feign.OAuth2FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "api-gateway", path = "/api/hangout-service", configuration = OAuth2FeignConfig.class)
public interface HangoutServiceClient {

    @RequestMapping(value = "/hangouts/test", method = RequestMethod.GET)
    String test();
}
