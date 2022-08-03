package com.prem.hotelmanagement.api.services;

import com.prem.hotelmanagement.api.constants.AppConstants;
import com.prem.hotelmanagement.api.models.Booking;
import com.prem.hotelmanagement.api.models.BookingStatus;
import com.prem.hotelmanagement.api.models.Customer;
import com.prem.hotelmanagement.api.models.Room;
import com.prem.hotelmanagement.api.repository.BookingStatusRepo;
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
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    BookingsRepository bookingsRepository;
    @Autowired
    RoomsRepository roomsRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookingStatusRepo bookingStatusRepo;

    @Override
    public ResponseEntity<String> createBooking(NewBooking bookingData) {
        SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        if(bookingData.getCustomerId() == 0) return new ResponseEntity<String>("Need valid userId", HttpStatus.NOT_ACCEPTABLE);
        if(bookingData.getRoomId() == 0) return new ResponseEntity<String>("Need valid roomId", HttpStatus.NOT_ACCEPTABLE);
        if(bookingData.getInTime() == null) return new ResponseEntity<String>("Need valid inTime", HttpStatus.NOT_ACCEPTABLE);


        Date inTime = new Date();
        Date outTime = new Date();
        try{
            inTime = formatter.parse(bookingData.getInTime());
            if (bookingData.getOutTime() !=null ) outTime = formatter.parse(bookingData.getOutTime());
            else outTime = null;
        }catch (Exception e){
            return new ResponseEntity<>("Invalid date | date format must be <dd-MMM-yyyy HH:mm:ss>", HttpStatus.EXPECTATION_FAILED);
        }

        Optional<Room> roomObj = roomsRepository.findById(bookingData.getRoomId());
        Optional<Customer> customerObj = userRepository.findById(bookingData.getCustomerId());
        if(!roomObj.isPresent()) return new ResponseEntity<>("Room not found", HttpStatus.NOT_FOUND);
        if(!customerObj.isPresent()) return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);

        Booking booking  = new Booking();

        booking.setRoomId(roomObj.get());
        booking.setCustomerId(customerObj.get());
        booking.setInTime(inTime);
        booking.setOutTime(outTime);
        booking.setBookingStatus(bookingStatusRepo.findById(AppConstants.BookingStatus.ACTIVE.id()).get());

        bookingsRepository.save(booking);
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
        return bookingsRepository.findAll();
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
