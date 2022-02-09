package com.revature.bank_p0a.menus.dashboardMenus;

import java.io.BufferedReader;
import java.math.BigDecimal;

import com.revature.bank_p0a.menus.Menu;
import com.revature.bank_p0a.models.BankAccount;
import com.revature.bank_p0a.services.BankAccountService;
import com.revature.bank_p0a.util.List;
import com.revature.bank_p0a.util.MenuRouter;

public class WithdrawalMenu extends Menu{
	
	private final BankAccountService bankAccountService;
	
	public WithdrawalMenu(BufferedReader consoleReader, MenuRouter router, BankAccountService bankAccountService) {
		super("Withdrawal", "/withdrawal", consoleReader, router);
		this.bankAccountService = bankAccountService;
		
	}

	@Override
	public void render() throws Exception {
		
		List<BankAccount> myList;
		
		myList = bankAccountService.findAllBankAccounts();

		String newId;
		double doubleBalance;
		
		for (int i = 0; i < myList.size(); i++) {
			doubleBalance = myList.get(i).getAvailableFunds();
			newId = myList.get(i).getBankAccountId();
		
		
		System.out.println("You have requested to make a withdrawal.\n" +
							"Your current balance is " + String.format("%.2f", doubleBalance) +"\n" +
							"You may not overdraft your account.");
		
		System.out.println("How much would you like to withdraw?\n");
		
		String userSelection = consoleReader.readLine();
		
		double check = doubleBalance - Double.parseDouble(userSelection);
		
		while( check < 0) {
			System.out.println("You do not have enough funds to withdraw that amount.\n");
			System.out.println("How much would you like to withdraw?\n");
			userSelection = consoleReader.readLine();
			check = doubleBalance - Double.parseDouble(userSelection);
		}
		
		doubleBalance = doubleBalance - Double.parseDouble(userSelection);
		
		System.out.println("Your new balance is " + String.format("%.2f", doubleBalance));
		
		bankAccountService.updateBalance(newId, doubleBalance);
							
							
	}
	
	}
}