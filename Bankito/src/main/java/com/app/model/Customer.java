package com.app.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
@Entity
@Table
public class Customer {
	@Id
	@GeneratedValue
	private int customerId;
	private String customerFirstname;
	private String customerLastname;
	private String customerEmail;
	private String customerPassword;
	private String customerCity;
	private long customerContact;
	//customer_address(improvising)
	private long customerBalance;

}
