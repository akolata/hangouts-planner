package com.hangoutsplanner.api.hangoutsplannerbff.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetUserInfoResponse {
    String firstName;
    String lastName;
    String provider;
}
