package com.app.model;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Customer {
	@TableGenerator(name = "customer_Gen", initialValue = 2021001)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "customer_Gen")
	private int customerId;
	private String customerFirstname;
	private String customerLastname;
	private String customerEmail;
	private String customerPassword;
	private String customerCity;
	private long customerContact;
	//customer_address(improvising)
	private long customerBalance;
	@TableGenerator(name = "Address_Gen", initialValue = 1710002380)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "Address_Gen")
	private long accountId;

}
