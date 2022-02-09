package com.revature.bank_p0a.menus.dashboardMenus;

import java.io.BufferedReader;
import java.math.BigDecimal;

import com.revature.bank_p0a.menus.Menu;
import com.revature.bank_p0a.services.BankAccountService;
import com.revature.bank_p0a.util.MenuRouter;
import com.revature.bank_p0a.models.BankAccount;
import com.revature.bank_p0a.util.List;

public class ViewBankAccountsMenu extends Menu {
	
	private final BankAccountService bankAccountService;
	
	public ViewBankAccountsMenu(BufferedReader consoleReader, MenuRouter router, BankAccountService bankAccountService) {
		super("ViewBankAccounts", "/my-bankAccounts", consoleReader, router);
		this.bankAccountService = bankAccountService;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		
		
		List<BankAccount> myList;	
		myList = bankAccountService.findAllBankAccounts();
		if(myList.size() == 0) {
			System.out.println("You do not have any bank accounts yet.");
			 router.transfer("/dashboard");
		}
		
		System.out.println("The details of your account are below:\n");
		
		for (int i = 0; i < myList.size(); i++) {
			System.out.println("Bank Account Name: " + myList.get(i).getBankAccountName() + "\n" + "Balance: " + myList.get(i).getAvailableFunds());
			
		}


	}
	
}
