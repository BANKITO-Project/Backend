package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
@Entity
@Table
public class Accounts {
	
private int customerId;

@TableGenerator(name = "Address_Gen", initialValue = 10000)
@Id
@GeneratedValue(strategy = GenerationType.TABLE, generator = "Address_Gen")
private int accountId;

}
