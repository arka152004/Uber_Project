package com.arka.uberbookingservice.dto;

import com.arka.uberprojectentityservice.models.ExactLocation;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookingDto {
    private Long passengerId;
    private ExactLocation startLocation;
    private ExactLocation endLocation;
}
