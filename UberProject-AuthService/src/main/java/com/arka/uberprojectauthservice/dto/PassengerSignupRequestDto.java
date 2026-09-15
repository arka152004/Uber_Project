package com.arka.uberprojectauthservice.dto;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PassengerSignupRequestDto {
    String email;
    String password;
    String phoneNumber;
    String name;
}
