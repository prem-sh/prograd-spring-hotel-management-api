package com.prem.hotelmanagement.api.services;

import com.prem.hotelmanagement.api.models.Employee;
import com.prem.hotelmanagement.api.requestSchemas.NewEmployee;
import com.prem.hotelmanagement.api.requestSchemas.UpdateEmployee;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface AdminService {
    ResponseEntity<String> createEmployee(NewEmployee employee);
    List<Employee> getEmployees();
    ResponseEntity<String> updateEmployee(UpdateEmployee employee, int id);
    ResponseEntity<String> deleteEmployee(int id);
}
