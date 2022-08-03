package com.prem.hotelmanagement.api.services;

import com.prem.hotelmanagement.api.models.Booking;
import com.prem.hotelmanagement.api.repository.BookingsRepository;
import com.prem.hotelmanagement.api.repository.RoomsRepository;
import com.prem.hotelmanagement.api.repository.UserRepository;
import com.prem.hotelmanagement.api.requestSchemas.NewBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    BookingsRepository bookingsRepository;
    @Autowired
    RoomsRepository roomsRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<String> createBooking(NewBooking bookingData) {
        SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        if(bookingData.getCustomerId() == 0) return new ResponseEntity<String>("Need valid userId", HttpStatus.NOT_ACCEPTABLE);
        if(bookingData.getRoomId() == 0) return new ResponseEntity<String>("Need valid roomId", HttpStatus.NOT_ACCEPTABLE);
        if(bookingData.getInTime() == null) return new ResponseEntity<String>("Need valid inTime", HttpStatus.NOT_ACCEPTABLE);

        Date inTime = new Date();
        Date outTime = new Date();




        Booking booking  = new Booking();
        booking.setRoomId(roomsRepository.getReferenceById(bookingData.getRoomId()));
        booking.setRoomId(roomsRepository.getReferenceById(bookingData.getRoomId()));

        return null;
    }

    @Override
    public ResponseEntity<String> cancelBooking(long bookingId) {
        return null;
    }

    @Override
    public ResponseEntity<String> updateBooking(Booking booking, long id) {
        return null;
    }

    @Override
    public List<Booking> getAllBooking() {
        return null;
    }

    @Override
    public List<Booking> getBookingByUserId(int id) {
        return null;
    }

    @Override
    public List<Booking> getBookingByStatus(String status) {
        return null;
    }

    @Override
    public List<Booking> getBookingByDate(String date) {
        return null;
    }

    @Override
    public List<Booking> getBookingByDate(String from, String to) {
        return null;
    }
}
