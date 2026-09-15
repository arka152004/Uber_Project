package com.arka.uberprojectlocationservice.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveDriverLocationRequestDto {
    String driverId;
    double latitude;
    double longitude;
}
