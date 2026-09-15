package com.arka.uberprojectauthservice.services;

import com.arka.uberprojectauthservice.models.Passenger;
import com.arka.uberprojectauthservice.repository.PassengerRepository;
import com.arka.uberprojectauthservice.security.AuthPassengerDetails;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
//this class is responsible for loading the user in the form of UserDetails object for auth
@Setter
@Service
public class UserDetailsServiceImp implements UserDetailsService {



    @Autowired
    private PassengerRepository passengerRepository;

    public UserDetailsServiceImp(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public UserDetailsServiceImp() {

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional <Passenger> passenger= passengerRepository.findPassengerByemail(email);

        if(passenger.isPresent()){
            return new AuthPassengerDetails(passenger.get());
        }
        else {
            throw new UsernameNotFoundException("Cannot find the passenger by the given email");
        }

    }
}
