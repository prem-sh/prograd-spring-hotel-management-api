package com.prem.hotelmanagement.api.repository;

import com.prem.hotelmanagement.api.models.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingStatusRepo extends JpaRepository<BookingStatus, Integer> {
    boolean existsByBookings_BookingStatus_NameLikeIgnoreCase(String name);
}
