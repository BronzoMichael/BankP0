package com.revature.bank_p0a.services;

import com.revature.bank_p0a.daos.BankAccountDAO;
import com.revature.bank_p0a.exceptions.InvalidRequestException;
import com.revature.bank_p0a.exceptions.ResourcePersistenceException;
import com.revature.bank_p0a.models.BankAccount;
import com.revature.bank_p0a.util.List;

public class BankAccountService {
	
	private final BankAccountDAO bankAccountDAO;
	private final CustomerService customerService;
	
	public BankAccountService(BankAccountDAO bankAccountDAO, CustomerService customerService) {
		this.bankAccountDAO = bankAccountDAO;
		this.customerService = customerService;
	}
	
	// TODO: Monster Creation implementation
	public void createBankAccount(BankAccount newBankAccount) {
		if(!isBankAccountValid(newBankAccount)) {
			throw new InvalidRequestException("The bank was provided invalid information");
		}
		
		newBankAccount.setOwner(customerService.getSessionCustomer());
		BankAccount createdBankAccount = bankAccountDAO.create(newBankAccount);
		
		if(createdBankAccount == null) {
			throw new ResourcePersistenceException("The bank account could not be persisted");
		}
	}
	
	private boolean isBankAccountValid(BankAccount newBankAccount) {
		
		if(newBankAccount == null) return false;
		if(newBankAccount.getBankAccountName() == null || newBankAccount.getBankAccountName().trim().equals("")) return false;
		if( String.valueOf(newBankAccount.getAvailableFunds()) == null || String.valueOf(newBankAccount.getAvailableFunds()).trim().equals("") || newBankAccount.getAvailableFunds() < 0) return false;
		return true;
	}
	
	public BankAccount findMyBankAccounts(String bankAccountName){
		return bankAccountDAO.findByBankAccountName(bankAccountName);
		
	}
	
	public List<BankAccount> findAllBankAccounts(){
		return bankAccountDAO.findAll();
	}
	
	public boolean updateBalance(String updatedBankAccount, double updatedBalance) {
		return bankAccountDAO.update(updatedBankAccount, updatedBalance);
	}

}
