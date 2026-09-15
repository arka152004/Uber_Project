package com.arka.uberbookingservice.Repository;

import com.arka.uberprojectentityservice.models.Driver;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

}
