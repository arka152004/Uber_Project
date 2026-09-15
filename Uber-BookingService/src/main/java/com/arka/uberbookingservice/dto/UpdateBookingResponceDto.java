package com.arka.uberbookingservice.dto;

import com.arka.uberprojectentityservice.models.BookingStatus;
import com.arka.uberprojectentityservice.models.Driver;
import lombok.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateBookingResponceDto {
    private Long bookingId;
    private BookingStatus status;
    private Optional<Driver> driver;
}
