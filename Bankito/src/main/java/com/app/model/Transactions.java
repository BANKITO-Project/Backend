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
public class Transactions {
	private int customerId;
	@Id
	@GeneratedValue
	private int transactionId;
	private String transactionType;
	private String transactionDate;
	private long transactionAmount;
	private String transactionStatus;

}
