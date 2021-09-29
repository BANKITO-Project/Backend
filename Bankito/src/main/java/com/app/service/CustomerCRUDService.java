package com.app.service;


import com.app.model.Customer;
public interface CustomerCRUDService {
	Customer updateCustomer(Customer customer);
	Customer getCustomerById(int customer_id);
	void deleteCustomer(int customer_id);
	Customer addCustomer(Customer customer) throws Exception;
	Customer findByCustomerEmail(String customerEmail);

	//boolean ifCustomerExist(String email) throws Exception;
}
