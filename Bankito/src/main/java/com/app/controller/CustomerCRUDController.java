package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.BusinessException.BusinessException;
import com.app.model.Customer;
import com.app.service.CustomerCRUDService;

@RestController
@CrossOrigin
public class CustomerCRUDController {

	@Autowired
	private CustomerCRUDService service;
	

	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) throws Exception {
		   Customer c=new Customer();
		  
	        String email=customer.getCustomerEmail();
	        c=service.findByCustomerEmail(email);
	        
	        if(c!=null) {
	        	throw new BusinessException("Email already exists");
	        }
	         c=null;
	         c=service.addCustomer(customer);
	         long n = (long)(Math.random()*(98897823578L-1111111111L)) + 1111111111L;
	         c.setAccountId(n);

	       
			return c;

	
		}

	

	@PutMapping("/customer")
	public Customer updateCustomer(@RequestBody Customer customer) {

		return service.updateCustomer(customer);

	}

	@GetMapping("/customer/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {
		 Customer c=new Customer();
		 
		   c=service.getCustomerById(customerId);
		  
		   
		return c;
	}

	@DeleteMapping("/customer/{customerId}")
	public void deleteCustomer(@PathVariable int customerId) {

		service.deleteCustomer(customerId);
	}

}
