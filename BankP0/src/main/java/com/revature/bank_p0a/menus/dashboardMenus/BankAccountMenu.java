package com.revature.bank_p0a.menus.dashboardMenus;

import java.io.BufferedReader;

import com.revature.bank_p0a.menus.Menu;
import com.revature.bank_p0a.models.BankAccount;
import com.revature.bank_p0a.services.BankAccountService;
import com.revature.bank_p0a.util.List;
import com.revature.bank_p0a.util.MenuRouter;

public class BankAccountMenu extends Menu{
	
	private final BankAccountService bankAccountService;
	public BankAccountMenu(BufferedReader consoleReader, MenuRouter router, BankAccountService bankAccountService) {
		super("BankAccount", "/bankAccount", consoleReader, router);
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

		System.out.println("Would you like to make a deposit or withdrawal?");
		String menu = "1) Deposit\n" +
						"2) Withdrawal\n";
		
		System.out.println(menu);
		
		String userSelection = consoleReader.readLine();

		switch (userSelection) {
		case "1":
			System.out.println("Deposit requested");
			router.transfer("/deposit");
			break;
		case "2":
			System.out.println("Withdrawal requested");
			router.transfer("/withdrawal");
			break;
		default:
			System.out.println("The user made an invalid selection");
		}
		
	}

}
