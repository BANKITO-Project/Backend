package com.app.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Customer;
import com.app.model.Transactions;
import com.app.repository.CustomerRepository;
import com.app.repository.TransactionsRepository;
import com.app.service.TransactionsService;


	@Service
	public class TransactionsServiceImpl implements TransactionsService{
		@Autowired
		private CustomerRepository repository;
		@Autowired
		private TransactionsRepository transactionrepository;

		@Override
		public Customer depositeAmount(int customerId,long damount) {
			Customer c=new Customer();
			Transactions transaction=new Transactions();
			transaction.setTransactionType("DEPOSIT");
			transaction.setCustomerId(customerId);
			 DateFormat date_format_obj = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		        Date date_obj = new Date();
		        String f="";
		        f=date_format_obj.format(date_obj);
		        transaction.setTransactionDate(f);
		        transaction.setTransactionAmount(damount);
		        transaction.setTransactionStatus("CREDITED SUCCESSFULLY");
		        transactionrepository.save(transaction);
			c=repository.findById(customerId).get();
			
			long upba=c.getCustomerBalance() + damount;
			c.setCustomerBalance(upba);
			repository.save(c);
			return c;
		}

		@Override
		public Customer withdrawAmount(int customerId,long wamount) {
			Customer c=new Customer();
			Transactions transaction=new Transactions();
			transaction.setTransactionType("WITHDRAWING");
			transaction.setCustomerId(customerId);
			 DateFormat date_format_obj = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		        Date date_obj = new Date();
		        String f="";
		        f=date_format_obj.format(date_obj);
		        transaction.setTransactionDate(f);
		        transaction.setTransactionAmount(wamount);
		        transaction.setTransactionStatus("WITHDRAWED SUCCESSFULLY");
		        transactionrepository.save(transaction);
			c=repository.findById(customerId).get();
			if(wamount <= c.getCustomerBalance()) {
			c.setCustomerBalance(c.getCustomerBalance() - wamount);
			repository.save(c);
			
		}
			return c;
		}
		

		@Override
		public List<Transactions> allTransactions(int customerId) {
			List<Transactions> transactions=transactionrepository.findByCustomerId(customerId);
			
			return transactions;
		}

		@Override
		public Customer amountTransfer(int customerId, long amount) {
			Customer c=new Customer();
			Transactions transaction=new Transactions();
			transaction.setTransactionType("TRANSFER");
			transaction.setCustomerId(customerId);
			 DateFormat date_format_obj = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		        Date date_obj = new Date();
		        String f="";
		        f=date_format_obj.format(date_obj);
		        transaction.setTransactionDate(f);
		        transaction.setTransactionAmount(amount);
		        transaction.setTransactionStatus("TRANSFER SUCCESS");
		        transactionrepository.save(transaction);
			c=repository.findById(customerId).get();
			if(amount <= c.getCustomerBalance()) {
			c.setCustomerBalance(c.getCustomerBalance() - amount);
			repository.save(c);
			
		}
			return c;
		}
		
	}

