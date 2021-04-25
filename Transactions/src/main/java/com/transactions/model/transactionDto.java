package com.transactions.model;

import java.util.Date;

//import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class transactionDto {

	private String transactionRef;
	
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date value_Date;
	private String payerName;
	private String payerAccount;
	private String payeeName; 
	private String payeeAccount;
	private double amount; 
	private boolean feedStatus;
	public String getTransactionRef() {
		return transactionRef;
	}
	public void setTransactionRef(String transactionRef) {
		this.transactionRef = transactionRef;
	}
	public Date getValue_Date() {
		return value_Date;
	}
	public void setValue_Date(Date value_Date) {
		this.value_Date = value_Date;
	}
	public String getPayerName() {
		return payerName;
	}
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}
	public String getPayerAccount() {
		return payerAccount;
	}
	public void setPayerAccount(String payerAccount) {
		this.payerAccount = payerAccount;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getPayeeAccount() {
		return payeeAccount;
	}
	public void setPayeeAccount(String payeeAccount) {
		this.payeeAccount = payeeAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean isFeedStatus() {
		return feedStatus;
	}
	public void setFeedStatus(boolean feedStatus) {
		this.feedStatus = feedStatus;
	}
	
	
}
