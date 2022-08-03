package com.prem.hotelmanagement.api.repository;

import com.prem.hotelmanagement.api.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Customer, Integer> {
}
