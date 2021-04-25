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


@Entity
@Table(name = "tb_transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column
	private String transactionRef;
	
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date Value_Date;
	private String payerName;
	private String payerAccount;
	private String payeeName; 
	private String payeeAccount;
	private double amount; 
	private boolean feedStatus;
	

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
		return Value_Date;
	}

	public void setValue_Date(Date Value_Date) {
		this.Value_Date = Value_Date;
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

	@Override
	public String toString() {
		return "Transaction [ID=" + ID + ", transactionRef=" + transactionRef + ", Value_Date=" + Value_Date
				+ ", payerName=" + payerName + ", payerAccount=" + payerAccount + ", payeeName=" + payeeName
				+ ", payeeAccount=" + payeeAccount + ", amount=" + amount + ", feedStatus=" + feedStatus + "]";
	}
	
	
}
