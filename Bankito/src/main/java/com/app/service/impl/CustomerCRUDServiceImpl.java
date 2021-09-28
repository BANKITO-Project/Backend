package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Customer;
import com.app.repository.CustomerRepository;
import com.app.service.CustomerCRUDService;


@Service
public class CustomerCRUDServiceImpl implements CustomerCRUDService {
	@Autowired
	private CustomerRepository repository;

	@Override
	public Customer updateCustomer(Customer customer) {

		return repository.save(customer);
	}

	@Override
	public Customer getCustomerById(int customerId) {

		return repository.findById(customerId).get();
	}

	@Override
	public void deleteCustomer(int customerId) {
		repository.deleteById(customerId);
	}

	@Override
	public Customer addCustomer(Customer customer) throws Exception {
    
		return repository.save(customer);
		}

	@Override
	public Customer findByCustomerEmail(String customerEmail) {
		Customer c=new Customer();
		c=repository.findByCustomerEmail(customerEmail);
		return c;
	
	}

//    @Override
//	public boolean ifCustomerExist(String email)throws Exception {
//		Customer c=new Customer();
//		c=repository.findByCustomerEmail(email);
//		
//		if(c.getCustomerEmail().equals(email)) {
//			return true;
//		}
//	   
//	   return false;
//}
}
