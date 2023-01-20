package com.hangoutsplanner.service.meetingservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "api-gateway")
public interface HangoutServiceClient {

    @RequestMapping(value = "/api/hangout-service/hangouts/test", method = RequestMethod.GET)
    String test();
}
