package com.prem.hotelmanagement.api.repository;

import com.prem.hotelmanagement.api.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingsRepository extends JpaRepository<Booking, Long> {
    @Query("select sum(b.rent) from Booking b where upper(b.bookingStatus.name) like upper(?1)")
    String getRentByStatus(String name);

}
