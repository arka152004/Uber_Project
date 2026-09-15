package com.arka.uberprojectlocationservice.services;

import com.arka.uberprojectlocationservice.dto.DriverLocationDto;

import org.springframework.stereotype.Service;

import java.util.List;


public interface LocationService {
    Boolean saveDriverLocation(String driverId, Double longitude, Double latitude);
    List<DriverLocationDto> getNearByDriver(Double longitude, Double latitude);
}
