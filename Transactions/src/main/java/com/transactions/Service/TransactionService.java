package com.transactions.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transactions.Repo.TransactionRepo;
import com.transactions.model.Transaction;

@Service
public class TransactionService {

	@Autowired 
	private TransactionRepo repo;
		
    public Transaction saveTransaction(Transaction transaction) {
        return repo.save(transaction);
    }

    public List<Transaction> saveTransactions(List<Transaction> transactions) {
        return repo.saveAll(transactions);
    }

    public List<Transaction> getTransactions() {
        return repo.findAll();
    }

    public Transaction getTransactionById(long id) {
        return repo.findById( id).orElse(null);
    }

    public String deleteProduct(long id) {
        repo.deleteById(id);
        return "product removed !! " + id;
    }

  
}
