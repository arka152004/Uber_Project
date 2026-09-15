package com.arka.reviewService.service;

import com.arka.reviewService.Models.Booking;

import com.arka.reviewService.Models.Driver;
import com.arka.reviewService.Models.Review;
import com.arka.reviewService.repository.BookingRepository;
import com.arka.reviewService.repository.DriverRepo;
import com.arka.reviewService.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {

    private final BookingRepository bookingRepository;
    private final ReviewRepository reviewRepository;
    private final DriverRepo driverRepo;


    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverRepo driverRepo) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepo = driverRepo;

    }

    @Override
    public void run(String... args) throws Exception {

//
//        System.out.println("****");
//        Review r = Review.builder()
//                .content("not too much comfortable")
//                .rating(3.5)
//                .build();
//        reviewRepository.save(r);
////
//        Booking b = Booking.builder()
//                .review(r)
//                .EndTime(new Date())
//                .build();
//        // Persist via cascade from Booking -> Review to avoid "detached entity passed to persist"
//        // (separate repository.save calls run in separate transactions by default).
//        bookingRepository.save(b);
//        System.out.println(r);
//
//
//        List<Review> reviews = reviewRepository.findAll();
//        for (Review review : reviews) {
//            System.out.println(review.getContent());
//        }

//        Optional<Driver> driver = driverRepo.findByIdAndLicenceNumber(1L, "DL534823");
//        {
//            if (driver.isPresent()) {
//                System.out.println(driver.get().getName());
//                List<Booking> bookings = bookingRepository.findByDriver_Id(1L);
//                for (Booking booking : bookings) {
//                    System.out.println(booking.getDriver().getName());
//                }
//            }
//
//
//        }

//
//        public Review addReview () {
//            Review r = Review.builder()
//                    .content("not too much comfortable")
//                    .rating(3.5)
//                    .build();
//
//        }

    }


    public Review publishReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> findAllReviews() {
       return this.reviewRepository.findAll();
    }

    public Optional<Review> findReviewById(Long reviewId) {
        return this.reviewRepository.findById(reviewId);
    }


    public boolean deleteReviewById(Long id) {
        try {
            Review review = this.reviewRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            this.reviewRepository.delete(review);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Review updateReview(Long reviewId, Review newReviewdata) {
        Review review = this.reviewRepository.findById(reviewId).orElseThrow(EntityNotFoundException::new);
        if(newReviewdata.getRating()!=null)
        {
            review.setRating(newReviewdata.getRating());
        }
        if(newReviewdata.getContent()!=null)
        {
            review.setContent(newReviewdata.getContent());
        }
    return   this.reviewRepository.save(review);
    }
}
