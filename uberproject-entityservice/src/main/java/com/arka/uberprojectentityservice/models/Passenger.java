package com.arka.uberprojectentityservice.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "bookings"})
public class Passenger extends BaseModels {
    private String name;


    @Column(nullable = false, name = "mobile_number")
    private String phoneNumber;

    @Column(nullable = false)
    private String email;


    @Column(nullable = false)
    private String password;


    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings = new ArrayList<>();

    @OneToOne
    private Booking activeBooking;


    private double rating;

    @OneToOne
    private ExactLocation lastKnownLocation;

    @OneToOne
    private ExactLocation homeLocation;
}
