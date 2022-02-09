package com.revature.bank_p0a.menus.dashboardMenus;

import java.io.BufferedReader;

import com.revature.bank_p0a.menus.Menu;
import com.revature.bank_p0a.models.BankAccount;
import com.revature.bank_p0a.services.BankAccountService;
import com.revature.bank_p0a.util.MenuRouter;

public class BankAccountCreationMenu extends Menu {

	private final BankAccountService bankAccountService;
	
	public BankAccountCreationMenu(BufferedReader consoleReader, MenuRouter router, BankAccountService bankAccountService) {
		super("BankAccountCreation", "/create-bankAccount", consoleReader, router);
		this.bankAccountService = bankAccountService;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		System.out.println("Creat New Bank Account\n" + "Please fill out the following questions");
		
		System.out.println("1 - Name of Account");
		String bankAccountName = consoleReader.readLine();
		System.out.println("2 - Starting funds");
		String availableFunds = consoleReader.readLine();
		
		while (!(availableFunds.matches("[0-9]+") && availableFunds.length() >= 1)) {
			
			System.out.println("It looks like you deposited something other than cash");
			System.out.println("2 - Starting funds");
			availableFunds = consoleReader.readLine();
		
		}
		
		BankAccount newBankAccount = new BankAccount(bankAccountName, availableFunds);
		
		bankAccountService.createBankAccount(newBankAccount);
	
		System.out.println("Thank you for creating a bank account!");
	}

}
