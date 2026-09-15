package com.arka.uberbookingservice.dto;

import com.arka.uberprojectentityservice.models.BookingStatus;
import com.arka.uberprojectentityservice.models.Driver;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookingResponceDto {
    private Long bookingId;
    private BookingStatus bookingStatus;
    private Optional<Driver> driver;
}
