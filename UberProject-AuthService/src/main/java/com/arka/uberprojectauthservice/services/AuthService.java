package com.arka.uberprojectauthservice.services;

import com.arka.uberprojectauthservice.dto.PassengerDto;
import com.arka.uberprojectauthservice.dto.PassengerSignupRequestDto;
import com.arka.uberprojectauthservice.models.Passenger;
import com.arka.uberprojectauthservice.repository.PassengerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.JDBCType;

@Service
public class AuthService {
    private final PassengerRepository passengerRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private JwtService jwtService;


    public AuthService(PassengerRepository passengerRepository, BCryptPasswordEncoder bCryptPasswordEncoder,JwtService jwtService) {
        this.passengerRepository = passengerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtService = jwtService;
    }

    public PassengerDto signupPassenger(PassengerSignupRequestDto passengerSignupRequestDto) {
        Passenger passenger=Passenger.builder()
                .email(passengerSignupRequestDto.getEmail())
                .name(passengerSignupRequestDto.getName())
                .password(bCryptPasswordEncoder.encode(passengerSignupRequestDto.getPassword())) // todo encrypt the password
                .phoneNumber(String.valueOf(passengerSignupRequestDto.getPhoneNumber()))
                .build();
       Passenger newPassenger= passengerRepository.save(passenger);

        return PassengerDto.from(newPassenger);
    }


}
