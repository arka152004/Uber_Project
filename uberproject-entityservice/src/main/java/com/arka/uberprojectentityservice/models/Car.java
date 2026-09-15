package com.arka.uberprojectentityservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car extends BaseModels{
    private String plateNumberr;

    @ManyToOne
    private Color color;

    private String brand;

    private String model;

    @Enumerated(EnumType.STRING)
    private CarType carType;

    @OneToOne
    private Driver driver;
}
