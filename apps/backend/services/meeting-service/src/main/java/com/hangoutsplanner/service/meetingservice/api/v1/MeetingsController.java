package com.hangoutsplanner.service.meetingservice.api.v1;

import com.hangoutsplanner.service.meetingservice.client.HangoutServiceClient;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
class MeetingsController {

    private final HangoutServiceClient hangoutServiceClient;

    @GetMapping("/api/v1/meetings/test")
    @Operation(summary = "Test meeting-service and OpenAPI UI")
    public ResponseEntity<Map<String, String>> test() {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String jwtAccessToken = jwtAuthenticationToken.getToken().getTokenValue();
        log.info("jwtAccessToken = {}", jwtAccessToken);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + jwtAccessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = "http://localhost:8081/api/v1/hangouts/test";
        log.info("Call {}", url);
        ResponseEntity<String> responseEntity = new RestTemplate().exchange(url, HttpMethod.GET, entity,
            new ParameterizedTypeReference<>() {
            });

        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Authorization", "Bearer " + jwtAccessToken);
        HttpEntity<String> entity2 = new HttpEntity<>(headers);
        String url2 = "http://localhost:8080/api/hangout-service/hangouts/test";
        log.info("Call {}", url2);
        ResponseEntity<String> responseEntity2 = new RestTemplate().exchange(url2, HttpMethod.GET, entity2,
            new ParameterizedTypeReference<>() {
            });

        log.info("Call using Feign");
        String test = hangoutServiceClient.test();

        Map<String, String> response = Map.of("meeting-service", "Hello from: " + this.getClass().getName(), "hangout-service",
            responseEntity.getBody());
        return ResponseEntity.ok(response);
    }
}
