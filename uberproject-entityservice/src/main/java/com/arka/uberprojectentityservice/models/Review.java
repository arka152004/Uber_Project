package com.arka.uberprojectentityservice.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name="bookingreview")
public class Review extends BaseModels {


    @Column(nullable = false)
    private String content;

    private Double rating;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Booking booking;


    @Override
    public String toString() {
        return "Review: " + this.content+ " "+ this.rating+" "+this.createdAt+" "+this.updateAT;
    }
}
