package com.arka.uberbookingservice.services;

import com.arka.uberbookingservice.dto.*;


public interface BookingService {


    CreateBookingResponceDto createBooking(CreateBookingDto bookingDetails);

    UpdateBookingResponceDto updateBooking(UpdateBookingRequestDto bookingRequestDto,Long bookingId);
}
