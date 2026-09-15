package com.arka.reviewService.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Passenger extends BaseModel{
    private String name;
    private String mobileNumber;
    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings= new ArrayList<>();
}
