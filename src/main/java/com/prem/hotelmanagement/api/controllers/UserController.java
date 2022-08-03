package com.prem.hotelmanagement.api.controllers;

import com.prem.hotelmanagement.api.models.Customer;
import com.prem.hotelmanagement.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<Customer> getAllCustomer(){
        return userService.getAllUsers();
    }
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<String> createNewUser(@RequestBody Customer customer){
        return userService.registerUser(customer);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateUser(@RequestBody Customer customer, @PathVariable int id){
        return userService.updateUserDetails(customer, id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id){
        return userService.removeUser(id);
    }
}
