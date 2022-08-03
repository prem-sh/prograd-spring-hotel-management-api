package com.prem.hotelmanagement.api.services;

import com.prem.hotelmanagement.api.models.Customer;
import com.prem.hotelmanagement.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepo;

    @Override
    public ResponseEntity<Customer> getUserById(int id) {
        Optional<Customer> userOpt = userRepo.findById(id);
        return userOpt.map(customer -> new ResponseEntity<>(customer, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Customer> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public ResponseEntity<String> registerUser(Customer customer) {
        if (customer.getAddress() != null && customer.getName() != null && customer.getPhone() != null) {
            Customer newCustomer = userRepo.save(customer);
            return new ResponseEntity<>("New Customer added successfully | User ID is "+newCustomer.getId(), HttpStatus.OK);
        }
        else return new ResponseEntity<>("Please provide all the customer details | name, address, phone", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> updateUserDetails(Customer customer, int id) {
        Optional<Customer> userOpt = userRepo.findById(id);
        if (userOpt.isPresent()){
            Customer user = userOpt.get();
            if (customer.getAddress() != null) user.setAddress(customer.getAddress());
            if (customer.getName() != null) user.setName(customer.getName());
            if (customer.getPhone() != null) user.setPhone(customer.getPhone());
            userRepo.save(user);
            return new ResponseEntity<>("Customer info updated", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> removeUser(int id) {
        Optional<Customer> userOpt = userRepo.findById(id);
        if (userOpt.isPresent()) userRepo.deleteById(id);
        return userOpt.map(customer -> new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>("Customer not found",HttpStatus.NOT_FOUND));
    }
}
