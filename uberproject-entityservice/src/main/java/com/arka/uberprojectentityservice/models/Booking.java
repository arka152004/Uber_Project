package com.arka.uberprojectentityservice.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(indexes = {
        @Index(columnList = "driver_id")
})
public class Booking extends BaseModels {

    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date StartTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date EndTime;


    private Long totalDistance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    private Passenger passenger;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "start_location_id")
    private ExactLocation startLocation;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "end_location_id")
    private ExactLocation endLocation;
}

