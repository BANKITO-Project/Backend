package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Customer;
import com.app.service.CustomerCRUDService;

@RestController
public class CustomerLoginValidationController {

	@Autowired
	private CustomerCRUDService service;
//	@GetMapping("/customer/login")
//	public Customer loginValidation(@RequestBody Customer customer) throws Exception {
//		Customer c=new Customer();
//		boolean flag=false;
//		
//		c=service.findByCustomerEmail(customer.getCustomerEmail());
//		
//		if(c.getCustomerPassword().equals(customer.getCustomerPassword())) {
//		flag=true;
//		}
//		if(flag) {
//			return c;
//		}else {
//			throw new Exception();
//		}
//	
//	}
	@PostMapping("/customer/login")
	public Customer loginValidation(@RequestBody Customer customer) throws Exception {
		Customer c = new Customer();
		boolean flag = false;

		c = service.findByCustomerEmail(customer.getCustomerEmail());

		if (c.getCustomerPassword().equals(customer.getCustomerPassword())) {
			flag = true;
		}
		if (flag) {
			return c;
		} else {
			throw new Exception();
		}
	}
  


}
