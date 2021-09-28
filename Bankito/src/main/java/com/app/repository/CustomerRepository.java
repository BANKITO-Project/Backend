package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	List<Customer> findByCustomerFirstname(String customerFirstname);
	
	List<Customer> findByCustomerCity(String customerCity);
	Customer findByCustomerEmail(String customerEmail);
	
	
	
}
