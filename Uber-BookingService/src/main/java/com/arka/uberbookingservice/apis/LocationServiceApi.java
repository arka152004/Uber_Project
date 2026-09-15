package com.arka.uberbookingservice.apis;

import com.arka.uberbookingservice.dto.DriverLocationDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LocationServiceApi {
    @POST("/api/location/nearby/drivers")
    Call<DriverLocationDto[]> getNearByDrivers(@Body DriverLocationDto driverLocationDto);
}
