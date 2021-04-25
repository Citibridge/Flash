package com.transactions.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.transactions.Service.TransactionService;
import com.transactions.model.Transaction;

@RestController
public class TransactionController {
	@Autowired
	private TransactionService service;
	
	@PostMapping("/addRecord")
    public Transaction addProduct(@RequestBody Transaction transaction) {
        return service.saveTransaction(transaction);
    }

    @PostMapping("/addRecords")
    public List<Transaction> addProducts(@RequestBody List<Transaction> transactions) {
        return service.saveTransactions(transactions);
    }

    @GetMapping("/records")
    public List<Transaction> findAllProducts() {
        return service.getTransactions();
    }

    @GetMapping("/recordById/{id}")
    public Transaction findProductById(@PathVariable int id) {
        return service.getTransactionById(id);
    }

}
