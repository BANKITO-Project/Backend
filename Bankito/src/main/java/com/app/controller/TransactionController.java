package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Customer;
import com.app.model.Transactions;
import com.app.service.TransactionsService;

@RestController
@CrossOrigin
public class TransactionController {
	
	
		@Autowired
		private TransactionsService service;
		

		@PutMapping("/deposite")
		public Customer amountDeposite(@RequestBody Transactions transaction) {
           int c=0;
           long amount=0;
           c=transaction.getCustomerId();amount=transaction.getTransactionAmount();
         
           
			return service.depositeAmount(c,amount);
		}

		@PutMapping("/withdraw")
		public Customer amountWithdrawal(@RequestBody Transactions transaction) {
			  int c=0;
	           long amount=0;
	           c=transaction.getCustomerId();amount=transaction.getTransactionAmount();
			return service.withdrawAmount(c,amount);
		}
		@GetMapping("/transactions/{customerId}")
		public List<Transactions> getAllTransactions(@PathVariable int customerId) {
			 
			return service.allTransactions(customerId);
			
		}
		@PutMapping("/transfer")
		public Customer amountTransfer(@RequestBody Transactions transaction) {
			  int c=0;
	           long amount=0;
	           c=transaction.getCustomerId();amount=transaction.getTransactionAmount();
			return service.amountTransfer(c,amount);
		}
		
		@GetMapping("/transaction/{id}")
		public Transactions getTransactionById(@PathVariable int id) {
			return service.getTransactionById(id);
		}
}
