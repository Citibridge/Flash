package com.transactions.Service;

//import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.transactions.Repo.TransactionRepo;
import com.transactions.model.Transaction;

@Service
public class TransactionService {

	@Autowired 
	private TransactionRepo repo;
		
	
	
	
	Date today = new java.util.Date();
	
	boolean invalidCharacterFlag;
	boolean invalidNumberFlag;
	boolean dateBeforeFlag;
	boolean dateAfterFlag;
	boolean invalidDateFormat;
	boolean nameLengthExceeded;
	boolean numberLengthInvalid;
	boolean invalidMonthFlag;
	boolean invalidDayFlag;
	boolean InvalidAmountFlag;
	boolean balanceExceededFlag;
	boolean invalidYearFlag;
	boolean invalidDateOccurance;

	
    public Transaction saveTransaction(Transaction transaction) {
    	//String today = java.util.Calendar.getInstance().getTime().toString().substring(0, 8);
    	String trans_ref = transaction.getTransactionRef();
    	Date date = transaction.getValue_Date();
    	String payername = transaction.getPayerName();
    	String payerAcc = transaction.getPayerAccount();
    	String payeename = transaction.getPayeeName();
    	String payeeAcc = transaction.getPayeeName();
    	double amt = transaction.getamount();
    	
    	boolean trans_ref_flag = checkAlphanumericString(trans_ref, 12);
    	boolean date_flag=checkDate(date);
    	boolean payername_flag = checkAlphanumericString(payername, 35);
    	boolean payerAcc_flag = checkAlphanumericString(payerAcc, 12); 
    	boolean payeename_flag = checkAlphanumericString(payeename,35);
    	boolean payeeAcc_flag = checkAlphanumericString(payeeAcc,12);
    	boolean amt_flag = checkAmount(amt);
    	if(trans_ref_flag == true && date_flag == true && payername_flag == true && payerAcc_flag == true
    			&& payeename_flag == true && payeeAcc_flag == true && amt_flag==true) {
    		
    		transaction.setFeedStatus(true);
    		
    	}
    	transaction.setFeedStatus(false);
    	return repo.save(transaction);
    }

    public List<Transaction> saveTransactions(List<Transaction> transactions) {
    	
        
    	for(int i =0;i<transactions.size();++i)
    	{
    		Transaction t = new Transaction();
    		t = transactions.get(i);
    		
    		String trans_ref = t.getTransactionRef();
    		Date date = t.getValue_Date();
    		String payername = t.getPayerName();
    		String payerAcc = t.getPayerAccount();
    		String payeename = t.getPayeeName();
    		String payeeAcc = t.getPayeeName();
    		double amt = t.getamount();
    		
    		boolean trans_ref_flag = checkAlphanumericString(trans_ref, 12);
        	boolean date_flag=checkDate(date);
        	boolean payername_flag = checkAlphanumericString(payername, 35);
        	boolean payerAcc_flag = checkAlphanumericString(payerAcc, 12); 
        	boolean payeename_flag = checkAlphanumericString(payeename,35);
        	boolean payeeAcc_flag = checkAlphanumericString(payeeAcc,12);
        	boolean amt_flag = checkAmount(amt);
        	if(trans_ref_flag == true && date_flag == true && payername_flag == true && payerAcc_flag == true
        			&& payeename_flag == true && payeeAcc_flag == true && amt_flag==true) {
        		
        		
            	t.setFeedStatus(true);
            	transactions.set(i, t);
        	}
        	else
        	{
        		t = transactions.get(i);
            	t.setFeedStatus(false);
            	transactions.set(i, t);
        	}
    	}    	
    	
    	return repo.saveAll(transactions);
        
    }

    public List<Transaction> getTransactions() {
    	
        return repo.findAll();
    }

    public Transaction getTransactionById(long id) {
        return repo.findById(id).orElse(null);
    }

    public String deleteProduct(long id) {
        repo.deleteById(id);
        return "product removed !! " + id;
    }

    
    public boolean checkAlphanumericString(String n, int lengthConstraint) {
		if (n.length() == 0) // Must not be a null
			return false;
		else if (n.length() > lengthConstraint) {// like string length <=35
			nameLengthExceeded = true;
			return false;
		}
		for (int i = 0; i < n.length(); i++) {
			if (n.charAt(i) > 57 || n.charAt(i) < 48) {// not 0-9
				// check further only if characters allowed
				if ((n.charAt(i) > 90 && n.charAt(i) < 97) || (n.charAt(i) > 122) || (n.charAt(i) < 65)) {// not A-Z //
																											// |a-z
					if (specialCharacter(n.charAt(i)) == false) {
						invalidCharacterFlag = true;
						return false;
					}
				}
			}
		}
		return true; // String passes the test cases

	}

	public boolean specialCharacter(char c) {
		if (c == 45 || c == 46)
			return true;
		else
			return false;
	}

	public boolean checkNumericString(String n) {
		if (n.length() == 0) // Must not be a null string & <=12
			return false;
		else if (n.length() > 12) {
			numberLengthInvalid = true;
			return false;
		}
		for (int i = 0; i < n.length(); i++) {
			if (n.charAt(i) > 57 || n.charAt(i) < 48) {// not 0-9
				invalidNumberFlag = true;
				return false;
			}
		}
		return true; // String passes the test cases

	}
	
	public boolean checkAmount(double amount) {

		if (amount < 0.00) {
			InvalidAmountFlag  = true;
			return false;
		} else if (amount > 9999999999.99) {
			InvalidAmountFlag  = true;
			return false;
		}

		return true;
	}

	public boolean checkDate(Date date)
	{
		if(date==today)
		{
			return true;
		}
		
		return false;
	}
  
}
