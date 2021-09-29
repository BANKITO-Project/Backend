package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Customer;
import com.app.service.CustomerSearchService;

import java.util.List;
@RestController
@CrossOrigin
public class CustomerSearchController {
		@Autowired
		private CustomerSearchService service;
		
		@GetMapping("/customers")
		public List<Customer> getAllCustomers() {
			
			return service.getAllCustomers();
		}

		@GetMapping("/customers/firstname/{name}")
		public List<Customer> getCustomersByName(@PathVariable String name) {
			// TODO Auto-generated method stub
			return service.getCustomerByName(name);
		}

		@GetMapping("/customers/city/{city}")
		public List<Customer> getCustomersByCity(@PathVariable String city) {
			// TODO Auto-generated method stub
			return service.getCustomerByCity(city);
		}
		@GetMapping("/customers/{customerId}")
		public long getCustomerBalance(@PathVariable int customerId) {
			// TODO Auto-generated method stub
			return service.getBalance(customerId);
		}

	}


