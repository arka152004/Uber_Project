//package com.arka.reviewService.adapters;
//
//import com.arka.reviewService.Models.Booking;
//import com.arka.reviewService.Models.Review;
//import com.arka.reviewService.dto.CreateReviewDto;
//import com.arka.reviewService.repository.BookingRepository;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
//
//
//@Component
//public class CreateReviewDtoToReviewAdapterImp implements CreateReviewDtoToReviewAdapter {
//
//
//    private BookingRepository bookingRepository;
//    public CreateReviewDtoToReviewAdapterImp(BookingRepository bookingRepository) {
//        this.bookingRepository = bookingRepository;
//    }
//    @Override
//    public Review convertDto(CreateReviewDto createReviewDto) {
//        Optional<Booking> booking=bookingRepository.findById(createReviewDto.getBookingId());
//        if(booking.isEmpty()){
//            return null;
//
//
//        }
//        Review review=Review.builder()
//                .rating(createReviewDto.getRating())
//                .booking(booking.get())
//                .content(createReviewDto.getContent())
//                .build();
//        return review;
//    }
//}


package com.arka.reviewService.adapters;

import com.arka.reviewService.Models.Booking;
import com.arka.reviewService.Models.Review;
import com.arka.reviewService.dto.CreateReviewDto;
import com.arka.reviewService.repository.BookingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class CreateReviewDtoToReviewAdapterImp implements CreateReviewDtoToReviewAdapter {

    private BookingRepository bookingRepository;

    public CreateReviewDtoToReviewAdapterImp(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Review convertDto(CreateReviewDto createReviewDto) {
        // Validate bookingId is not null
        if (createReviewDto.getBookingId() == null) {
            throw new IllegalArgumentException("Booking ID cannot be null");
        }

        Optional<Booking> booking = bookingRepository.findById(createReviewDto.getBookingId());

        if (booking.isEmpty()) {
            throw new IllegalArgumentException("Booking not found with ID: " + createReviewDto.getBookingId());
        }

        Review review = Review.builder()
                .rating(createReviewDto.getRating())
                .booking(booking.get())
                .content(createReviewDto.getContent())
                .build();

        return review;
    }
}