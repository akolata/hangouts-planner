package com.hangoutsplanner.service.hangoutservice.api.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HangoutsController {

    @GetMapping("/api/v1/hangouts/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello from: " + this.getClass().getName());
    }
}
