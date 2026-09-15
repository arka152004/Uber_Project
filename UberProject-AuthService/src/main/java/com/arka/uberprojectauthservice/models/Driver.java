package com.arka.uberprojectauthservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLaxyInitializer","handler","bookings"})
public class Driver extends BaseModel {

    private String name;

    @Column(nullable = false, unique = true)
    private String licenceNumber;

    @OneToMany(mappedBy ="driver", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings=new ArrayList<>();
}