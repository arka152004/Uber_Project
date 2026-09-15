package com.arka.uberprojectlocationservice.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverLocationDto {
     String driverId;
     Double longitude;
     Double latitude;
}
