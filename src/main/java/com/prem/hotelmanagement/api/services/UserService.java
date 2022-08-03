package com.prem.hotelmanagement.api.services;

import com.prem.hotelmanagement.api.models.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<Customer> getUserById(int id);
    List<Customer> getAllUsers();
    ResponseEntity<String> registerUser(Customer customer);
    ResponseEntity<String> updateUserDetails(Customer customer, int id);
    ResponseEntity<String> removeUser(int id);
}
