package com.arka.reviewService.repository;

import com.arka.reviewService.Models.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepo extends CrudRepository<Driver, Long> {
    ;

    Optional<Driver> findByIdAndLicenceNumber(long Id, String LicenseNumber);
}
