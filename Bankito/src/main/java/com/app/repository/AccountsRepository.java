package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, Integer> {

}
