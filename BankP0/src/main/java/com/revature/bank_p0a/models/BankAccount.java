package com.revature.bank_p0a.models;

public class BankAccount {
	
	private String BankAccountId;
	private String BankAccountName;
	private double AvailableFunds;
	private Customer owner;
	
	
	public BankAccount() {
		super();
	}


	public BankAccount(String bankAccountId, String bankAccountName, double availableFunds, Customer owner) {
		super();
		BankAccountId = bankAccountId;
		BankAccountName = bankAccountName;
		AvailableFunds = availableFunds;
		this.owner = owner;
	}


	public BankAccount(String bankAccountName, double availableFunds, Customer owner) {
		super();
		BankAccountName = bankAccountName;
		AvailableFunds = availableFunds;
		this.owner = owner;
	}
	
	public BankAccount(String bankAccountName, double availableFunds) {
		super();
		BankAccountName = bankAccountName;
		AvailableFunds = availableFunds;
	}
	
	public BankAccount(String bankAccountName, String availableFunds) {
		super();
		BankAccountName = bankAccountName;
		AvailableFunds = Double.parseDouble(availableFunds);
	}


	public String getBankAccountId() {
		return BankAccountId;
	}


	public void setBankAccountId(String bankAccountId) {
		BankAccountId = bankAccountId;
	}


	public String getBankAccountName() {
		return BankAccountName;
	}


	public void setBankAccountName(String bankAccountName) {
		BankAccountName = bankAccountName;
	}


	public double getAvailableFunds() {
		return AvailableFunds;
	}


	public void setAvailableFunds(double availableFunds) {
		AvailableFunds = availableFunds;
	}


	public Customer getOwner() {
		return owner;
	}


	public void setOwner(Customer owner) {
		this.owner = owner;
	}
	
	
	
	
	
	
	
	
	
	

}

