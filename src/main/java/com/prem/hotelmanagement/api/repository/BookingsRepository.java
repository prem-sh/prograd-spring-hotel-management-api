package com.prem.hotelmanagement.api.repository;

import com.prem.hotelmanagement.api.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingsRepository extends JpaRepository<Booking, Long> {
}
