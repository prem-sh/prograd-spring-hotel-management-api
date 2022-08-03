package com.prem.hotelmanagement.api.controllers;

import com.prem.hotelmanagement.api.models.Booking;
import com.prem.hotelmanagement.api.requestSchemas.NewBooking;
import com.prem.hotelmanagement.api.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    BookingService bookingService;
    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingService.getAllBooking();
    }
    @GetMapping("user/{id}")
    public List<Booking> getByUser(@PathVariable int id){
        return bookingService.getBookingByUserId(id);
    }
    @GetMapping("status/{status}")
    public List<Booking> getByStatus(@PathVariable String status){
        return bookingService.getBookingByStatus(status);
    }
    @GetMapping("date/{date}")
    public List<Booking> getByDate(@PathVariable String bookingDate){
        return  bookingService.getBookingByDate(bookingDate);
    }
    @GetMapping("date")
    public List<Booking> getByDate(@RequestParam(name="from") String from, @RequestParam(name="to") String to){
        return  bookingService.getBookingByDate(from, to);
    }
    @PostMapping
    public ResponseEntity<String> createNewBooking(@RequestBody NewBooking booking){
        return bookingService.createBooking(booking);
    }
}
