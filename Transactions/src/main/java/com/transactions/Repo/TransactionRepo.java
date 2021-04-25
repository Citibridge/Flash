package com.transactions.Repo;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.web.bind.annotation.PathVariable;

import com.transactions.model.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {	

}
