package com.prem.hotelmanagement.api.controllers;

import com.prem.hotelmanagement.api.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

//    @Autowired
//    AdminService adminService;

    @GetMapping("/revenue")
    public ResponseEntity<String> getTotalRevenue(){
        return new ResponseEntity<String>("", HttpStatus.OK);
    }
}
