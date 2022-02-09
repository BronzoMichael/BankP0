package com.revature.bank_p0a.menus.dashboardMenus;

import java.io.BufferedReader;
import java.math.BigDecimal;

import com.revature.bank_p0a.menus.Menu;
import com.revature.bank_p0a.models.BankAccount;
import com.revature.bank_p0a.services.BankAccountService;
import com.revature.bank_p0a.util.List;
import com.revature.bank_p0a.util.MenuRouter;

public class DepositMenu extends Menu{
	
	private final BankAccountService bankAccountService;
	
	public DepositMenu(BufferedReader consoleReader, MenuRouter router, BankAccountService bankAccountService) {
		super("Deposit", "/deposit", consoleReader, router);
		this.bankAccountService = bankAccountService;
		
	}

	
	
	@Override
	public void render() throws Exception {

		
		List<BankAccount> myList;	
		myList = bankAccountService.findAllBankAccounts();
		if(myList.size() == 0) {
			System.out.println("You do not have any bank accounts yet.");
			 router.transfer("/dashboard");
		}
		String newId;
		double doubleBalance;
		
		for (int i = 0; i < myList.size(); i++) {
			doubleBalance = myList.get(i).getAvailableFunds();
			newId = myList.get(i).getBankAccountId();
		
		
		System.out.println("You have requested to make a deposit.\n" +
							"Your current balance is " + String.format("%.2f", doubleBalance));
		
		System.out.println("How much would you like to deposit?");
		
		String userSelection = consoleReader.readLine();
		
		while(userSelection.contains("-")) {
			System.out.println("You may not make a negative deposit.");
			System.out.println("How much would you like to deposit?");
			userSelection = consoleReader.readLine();
			
		}
		
		doubleBalance = doubleBalance + Double.parseDouble(userSelection);
		
		System.out.println("Your new balance is " + String.format("%.2f", doubleBalance));
		
		bankAccountService.updateBalance(newId, doubleBalance);
							
							
	}
	
	}
}