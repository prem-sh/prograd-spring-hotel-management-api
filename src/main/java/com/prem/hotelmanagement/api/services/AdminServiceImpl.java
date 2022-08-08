package com.prem.hotelmanagement.api.services;

import com.prem.hotelmanagement.api.models.Employee;
import com.prem.hotelmanagement.api.models.Role;
import com.prem.hotelmanagement.api.repository.EmployeeRepository;
import com.prem.hotelmanagement.api.repository.RoleRepository;
import com.prem.hotelmanagement.api.requestSchemas.NewEmployee;
import com.prem.hotelmanagement.api.requestSchemas.UpdateEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service()
public class AdminServiceImpl implements AdminService{
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<String> createEmployee(NewEmployee employee) {
        Employee newEmployee = new Employee();
        if(employee.getFullname() != null) newEmployee.setFullname(employee.getFullname());
        else return new ResponseEntity<String>("Employee Should have name", HttpStatus.NOT_ACCEPTABLE);
        if(employee.getEmail() != null) newEmployee.setEmail(employee.getEmail());
        else return new ResponseEntity<String>("Employee Should have email", HttpStatus.NOT_ACCEPTABLE);
        if(employee.getPassword() != null) newEmployee.setPassword(passwordEncoder.encode(employee.getPassword()));
        else return new ResponseEntity<String>("Employee Should have password", HttpStatus.NOT_ACCEPTABLE);
        if(employee.getRole() != null) {
            Optional<Role> roleOptional = roleRepository.findByRoleName(employee.getRole().toUpperCase());
            if (roleOptional.isEmpty()) new ResponseEntity<String>("Role must be 'ADMIN' or 'RECEPTIONIST'", HttpStatus.NOT_ACCEPTABLE);
            else {
                Set<Role> roles = newEmployee.getRoles();
                roles.add(roleOptional.get());
            }
        }else return new ResponseEntity<String>("Employee Should have a role and Role must be 'ADMIN' or 'RECEPTIONIST'", HttpStatus.NOT_ACCEPTABLE);
        Employee saved = employeeRepository.save(newEmployee);
        return new ResponseEntity<String>("Employee successfully created with role : "+employee.getRole().toUpperCase()+" and ID : "+saved.getId(), HttpStatus.CREATED);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public ResponseEntity<String> updateEmployee(UpdateEmployee employee, int id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isEmpty()) return new ResponseEntity<String>("Employee NOT FOUND", HttpStatus.NOT_FOUND);
        Employee subjectEmployee = (Employee) employeeOptional.get();

        if(employee.getFullname() != null) subjectEmployee.setFullname(employee.getFullname());
        if(employee.getEmail() != null) subjectEmployee.setEmail(employee.getEmail());
        if(employee.getPassword() != null) subjectEmployee.setPassword(passwordEncoder.encode(employee.getPassword()));
        if(employee.getRole() != null) {
            Optional<Role> roleOptional = roleRepository.findByRoleName(employee.getRole().toUpperCase());
            if (roleOptional.isEmpty()) new ResponseEntity<String>("Role must be 'ADMIN' or 'RECEPTIONIST'", HttpStatus.NOT_ACCEPTABLE);
            else {
                Set<Role> roles = subjectEmployee.getRoles();
                roles.add(roleOptional.get());
            }
        }
        employeeRepository.save(subjectEmployee);
        return new ResponseEntity<String>("Employee successfully UPDATED", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteEmployee(int id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isEmpty()) return new ResponseEntity<String>("Employee NOT FOUND", HttpStatus.NOT_FOUND);
        employeeRepository.deleteById(id);
        return new ResponseEntity<String>("Employee Deleted Successfully", HttpStatus.OK);
    }
}
