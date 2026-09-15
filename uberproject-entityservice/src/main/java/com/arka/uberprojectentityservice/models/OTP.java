package com.arka.uberprojectentityservice.models;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Random;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OTP extends  BaseModels{
    private String code;

    private String sentTONumber;

    public static OTP make(String phoneNumber){
        Random random = new Random();
        int x  = random.nextInt(900000)+10000000;
        return OTP.builder().sentTONumber(phoneNumber).build();
    }
}
