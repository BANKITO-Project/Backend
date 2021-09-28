package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.model.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer>{
	List<Transactions> findByCustomerId(int customerId);

}
