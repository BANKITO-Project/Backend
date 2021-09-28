package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Customer;
import com.app.repository.CustomerRepository;
import com.app.service.CustomerSearchService;

@Service
public class CustomerSearchServiceImpl implements CustomerSearchService {
	@Autowired
	private CustomerRepository repository;

	@Override
	public List<Customer> getCustomerByName(String customerFirstname) {

		return repository.findByCustomerFirstname(customerFirstname);
	}

	@Override
	public List<Customer> getCustomerByCity(String customerCity) {

		return repository.findByCustomerCity(customerCity);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return repository.findAll();
	}

	@Override
	public long getBalance(int customerId) {
		Customer c=new Customer();
		c= repository.findById(customerId).get();
		return c.getCustomerBalance();
	}

}
