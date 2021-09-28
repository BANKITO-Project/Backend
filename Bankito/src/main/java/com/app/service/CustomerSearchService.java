package com.app.service;

import java.util.List;

//import org.springframework.stereotype.Service;

import com.app.model.Customer;


public interface CustomerSearchService {
	List<Customer> getAllCustomers();
	List<Customer> getCustomerByName(String customerFirstname);
	List<Customer> getCustomerByCity(String customerCity);
	long getBalance(int customerId);
}
