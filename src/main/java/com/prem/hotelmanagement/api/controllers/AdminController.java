package com.prem.hotelmanagement.api.controllers;

import com.prem.hotelmanagement.api.models.Employee;
import com.prem.hotelmanagement.api.requestSchemas.NewEmployee;
import com.prem.hotelmanagement.api.requestSchemas.UpdateEmployee;
import com.prem.hotelmanagement.api.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("employee")
    public ResponseEntity<String> createEmployee(@RequestBody NewEmployee employee){
        return adminService.createEmployee(employee);
    }
    @GetMapping("employees")
    public List<Employee> getEmployees(){
        return adminService.getEmployees();
    }
    @PutMapping("employee/{id}")
    public ResponseEntity<String> updateEmployee(@RequestBody UpdateEmployee employee,@PathVariable int id){
        return adminService.updateEmployee(employee, id);
    }
    @DeleteMapping("employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){
        return adminService.deleteEmployee(id);
    }


}
