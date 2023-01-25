package com.hangoutsplanner.service.hangoutsplannerbffservice.user;

import com.hangoutsplanner.api.hangoutsplannerbff.v1.GetUserInfoResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
class UserInfoController {

    @GetMapping(path = "/user-info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserInfoResponse> getUserInfo() {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        GetUserInfoResponse response = GetUserInfoResponse.builder()
            .firstName(jwtAuthenticationToken.getToken().getClaim("given_name"))
            .lastName(jwtAuthenticationToken.getToken().getClaim("family_name"))
            .provider(jwtAuthenticationToken.getToken().getClaim("iss"))
            .build();
        return ResponseEntity.ok(response);
    }
}
