package com.revature.bank_p0a.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.bank_p0a.daos.BankAccountDAO;
import com.revature.bank_p0a.daos.CustomerDAO;
import com.revature.bank_p0a.exceptions.InvalidRequestException;
import com.revature.bank_p0a.exceptions.ResourcePersistenceException;
import com.revature.bank_p0a.models.BankAccount;


public class BankAccountServiceTestSuite {
	BankAccountService bas;
	BankAccountDAO mockBankAccountDAO;
	CustomerService mockCustomerService;
	
	
	@Before
	public void testPrep() {
		mockBankAccountDAO = mock(BankAccountDAO.class);
		bas = new BankAccountService(mockBankAccountDAO, mockCustomerService);
	}
	
	
	
	
	

}
