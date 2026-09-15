package com.arka.reviewService.Models;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class PassengerReview extends Review {
    private String passengerReviewContent;
    private String passengerRatting;
}
