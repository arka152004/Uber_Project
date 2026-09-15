package com.arka.uberprojectlocationservice.controllers;

import com.arka.uberprojectlocationservice.dto.NearbyDriversRequestDto;
import com.arka.uberprojectlocationservice.dto.SaveDriverLocationRequestDto;
import org.apache.coyote.Response;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private StringRedisTemplate stringRedisTemplate;
    private static final String DRIVER_GEO_OPS_KEY="drivers";
    private static final Double SEARCH_REDIUS=5.0;


    public LocationController(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }


    @PostMapping("/drivers")
    public ResponseEntity<Boolean> saveDriverLocation(@RequestBody SaveDriverLocationRequestDto saveDriverLocationRequestDto){
        System.out.println("in the controller");

        try{
            System.out.println("Saving to Redis at: " + stringRedisTemplate.getConnectionFactory().getConnection().ping());


            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/nearby/drivers")
    public ResponseEntity<List<String>> getNearbyDrivers(@ModelAttribute NearbyDriversRequestDto nearbyDriversRequestDto) {

        try {

            List<String> drivers=new ArrayList<>();
            return new ResponseEntity<>(drivers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
