package com.transactions.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tb_transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	@Column
	private String transactionRef;
	private String username;
	
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date value_Date;
	private String payerName;
	@JsonIgnore
	private String payerAccount;
	private String payeeName; 
	@JsonIgnore
	private String payeeAccount;
	private double amount; 
	private boolean feedStatus;
	
	
	public Transaction() {
		
	}
	
	public Transaction(String transactionRef, String username, Date value_Date, String payerName,
			String payerAccount, String payeeName, String payeeAccount, double amount, boolean feedStatus) {
		super();
		this.transactionRef = transactionRef;
		this.username = username;
		this.value_Date = value_Date;
		this.payerName = payerName;
		this.payerAccount = payerAccount;
		this.payeeName = payeeName;
		this.payeeAccount = payeeAccount;
		this.amount = amount;
		this.feedStatus = feedStatus;
	}

	public boolean isFeedStatus() {
		return feedStatus;
	}

	public void setFeedStatus(boolean feedStatus) {
		this.feedStatus = feedStatus;
	}

	public String getTransactionRef() {
		return transactionRef;
	}

	public void setTransactionRef(String transactionRef) {
		this.transactionRef = transactionRef;
	}

	@JsonFormat(pattern = "dd-mm-yyyy")
	public Date getValue_Date() {
		return value_Date;
	}

	public void setValue_Date(Date Value_Date) {
		this.value_Date = Value_Date;
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

	public double getamount() {
		return amount;
	}

	public void setamount(double amount) {
		this.amount = amount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Transaction [ID=" + ID + ", transactionRef=" + transactionRef + ", username=" + username
				+ ", value_Date=" + value_Date + ", payerName=" + payerName + ", payerAccount=" + payerAccount
				+ ", payeeName=" + payeeName + ", payeeAccount=" + payeeAccount + ", amount=" + amount + ", feedStatus="
				+ feedStatus+"]";
	}
	
	
}
