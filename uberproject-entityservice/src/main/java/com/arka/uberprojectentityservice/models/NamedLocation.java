package com.arka.uberprojectentityservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NamedLocation extends BaseModels {
    @OneToOne
    private ExactLocation exactLocation;
    private String name;
    private String city;
    private String zipCode;
    private String country;
    private String state;

}
