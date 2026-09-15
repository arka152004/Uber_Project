package com.arka.uberprojectauthservice.controllers;

import com.arka.uberprojectauthservice.dto.AuthRequestDto;
import com.arka.uberprojectauthservice.dto.PassengerDto;
import com.arka.uberprojectauthservice.dto.PassengerSignupRequestDto;
import com.arka.uberprojectauthservice.services.AuthService;
import com.arka.uberprojectauthservice.services.JwtService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {


    private AuthService authService;
    private final AuthenticationManager authenticationManager;
    private JwtService jwtService;


    public AuthController(AuthService authService,AuthenticationManager authenticationManager,JwtService jwtService) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/signup/passenger")
    public ResponseEntity<PassengerDto> signUp(@RequestBody PassengerSignupRequestDto  passengerSignupRequestDto){
       PassengerDto responce= authService.signupPassenger(passengerSignupRequestDto);
        return new ResponseEntity<>(responce, HttpStatus.OK);
    }

    @PostMapping("/signin/passenger")
    public ResponseEntity<?> signIn(@RequestBody AuthRequestDto authRequestDto)
    {
        System.out.println("request received");
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getEmail(), authRequestDto.getPassword()));

        if(authentication.isAuthenticated()){
            Map<String,Object> payload = new HashMap<>();
            payload.put("email",authRequestDto.getEmail());
            String jwtTocken=jwtService.createTocken(authRequestDto.getEmail());
            return new  ResponseEntity<>(jwtTocken,HttpStatus.OK);
        }
        return new ResponseEntity<>("Auth not successsfull",HttpStatus.OK);
    }
}
