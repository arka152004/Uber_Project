package com.arka.uberbookingservice.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;


@Configuration
public class RetrofinConfig {

    @Bean
    public Retrofit retrofit(){
        return new Retrofit.Builder()
                .baseUrl("http://localhost:6380")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}






