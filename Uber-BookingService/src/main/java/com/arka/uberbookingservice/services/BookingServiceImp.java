package com.arka.uberbookingservice.services;
import com.arka.uberbookingservice.Repository.BookingRepository;
import com.arka.uberbookingservice.Repository.DriverRepository;
import com.arka.uberbookingservice.Repository.PassengerRepository;
import com.arka.uberbookingservice.dto.*;
import com.arka.uberprojectentityservice.models.Booking;
import com.arka.uberprojectentityservice.models.BookingStatus;
import com.arka.uberprojectentityservice.models.Driver;
import com.arka.uberprojectentityservice.models.Passenger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;



@Service
public class BookingServiceImp implements BookingService {

    private final PassengerRepository passengerRepository;
    private final BookingRepository bookingRepository;
    private final RestTemplate restTemplate;

    private static final String LOCATION_SERVICE = "http://localhost:6380";
    private final DriverRepository driverRepository;

    // Constructor injection
    public BookingServiceImp(PassengerRepository passengerRepository,
                             BookingRepository bookingRepository, RestTemplate restTemplate, DriverRepository driverRepository) {
        this.passengerRepository = passengerRepository;
        this.bookingRepository = bookingRepository;

        this.restTemplate = restTemplate;
        this.driverRepository = driverRepository;
    }

    @Override
    public CreateBookingResponceDto createBooking(CreateBookingDto bookingDetails) {

        Passenger passenger = passengerRepository
                .findById(bookingDetails.getPassengerId())
                .orElseThrow(() -> new RuntimeException("Passenger not found"));


        Booking booking = Booking.builder()
                .passenger(passenger)
                .bookingStatus(BookingStatus.ASSIGNING_DRIVER)
                .startLocation(bookingDetails.getStartLocation())
                .endLocation(bookingDetails.getEndLocation())
                .build();
        Booking newBooking = bookingRepository.save(booking);

        //api call location service\

        NearbyDriversRequestDto requestDto = NearbyDriversRequestDto.builder()
                .latitude(bookingDetails.getStartLocation().getLatitude())
                .longitude(bookingDetails.getStartLocation().getLongitude())
                .build();

       ResponseEntity<DriverLocationDto[]> result= restTemplate
               .postForEntity(LOCATION_SERVICE + "/api/location/nearby/drivers",requestDto,DriverLocationDto[].class);

       if(result.getStatusCode().is2xxSuccessful() && result.getBody() != null) {
           List<DriverLocationDto> driverLocations = Arrays.asList(result.getBody());
           driverLocations.forEach(driverLocationDto -> {
               System.out.println(driverLocationDto.getDriverId() + " " + "lat" + driverLocationDto.getLatitude() + " long" + driverLocationDto.getLongitude());
           });
       }


        CreateBookingResponceDto response = new CreateBookingResponceDto();
        response.setBookingId(newBooking.getId());
        response.setBookingStatus(newBooking.getBookingStatus());
        response.setDriver(Optional.ofNullable(newBooking.getDriver()));
        return response;
    }

    @Override
    public UpdateBookingResponceDto updateBooking(UpdateBookingRequestDto bookingRequestDto, Long bookingId) {
        Optional<Driver> driver = bookingRequestDto.getDriverId()
                .flatMap(driverRepository::findById);
        if (driver.isPresent()) {
            bookingRepository.updateBookingStatusAndDriverById(bookingId,bookingRequestDto.getStatus(),bookingRequestDto.getDriverId().get());
            Booking booking = bookingRepository.findById(bookingId).get();
            return UpdateBookingResponceDto.builder()
                    .bookingId(bookingId)
                    .status(booking.getBookingStatus())
                    .driver(Optional.ofNullable(booking.getDriver()))
                    .build();
        }
        return null;
    }
}
