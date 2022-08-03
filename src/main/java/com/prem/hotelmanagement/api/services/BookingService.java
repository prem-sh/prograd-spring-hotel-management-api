package com.prem.hotelmanagement.api.services;

import com.prem.hotelmanagement.api.models.Booking;
import com.prem.hotelmanagement.api.requestSchemas.NewBooking;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface BookingService {
    ResponseEntity<String> createBooking(NewBooking booking);
    ResponseEntity<String> cancelBooking(long bookingId);
    ResponseEntity<String> updateBooking(Booking booking, long id);
    List<Booking> getAllBooking();
    List<Booking> getBookingByUserId(int id);
    List<Booking> getBookingByStatus(String status);
    List<Booking> getBookingByDate(String date);
    List<Booking> getBookingByDate(String from, String to);
}
