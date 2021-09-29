package com.app.service;
import java.util.List;

import com.app.model.*;

public interface TransactionsService {
	Customer depositeAmount(int customerId,long damount);
	 Customer withdrawAmount(int customerId,long wamount) ;
	 List<Transactions> allTransactions(int customerId);
	 Customer amountTransfer(int customerId,long amount);
	 Transactions getTransactionById(int transactionId);
//	   deposite(custmer_id,amount)
//	   withdraw(customer_id,amount)
	   
}
