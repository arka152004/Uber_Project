package com.arka.uberbookingservice.Repository;

import com.arka.uberprojectentityservice.models.Booking;
import com.arka.uberprojectentityservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("UPDATE Booking b SET b.bookingStatus= :status, b.driver=:driver WHERE b.id=:id")
   void  updateBookingStatusAndDriverById(@Param("id") Long id, @Param("status") String status,@Param("driver") Long driver);
}
