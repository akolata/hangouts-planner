package com.hangoutsplanner.service.meetingservice.api.v1;

import com.hangoutsplanner.service.meetingservice.client.HangoutServiceClient;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
class MeetingsController {

    private final HangoutServiceClient hangoutServiceClient;

    @GetMapping("/api/v1/meetings/test")
    @Operation(summary = "Test meeting-service and OpenAPI UI")
    public ResponseEntity<Map<String, String>> test() {
        Map<String, String> response = Map.of("meeting-service", "Hello from: " + this.getClass().getName(), "hangout-service",
            hangoutServiceClient.test());
        return ResponseEntity.ok(response);
    }
}
