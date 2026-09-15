package com.arka.uberprojectentityservice.models;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ExactLocation extends BaseModels {
    private Double latitude;
    private Double longitude;
}