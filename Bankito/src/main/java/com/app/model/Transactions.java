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
public class Transactions {
	private int customerId;
	@TableGenerator(name = "transaction_Gen", initialValue =1100201)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "transaction_Gen")
	private int transactionId;
	private String transactionType;
	private String transactionDate;
	private long transactionAmount;
	private String transactionStatus;

}
