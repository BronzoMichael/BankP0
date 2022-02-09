package com.revature.bank_p0a.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.bank_p0a.daos.BankAccountDAO;
import com.revature.bank_p0a.daos.CustomerDAO;
import com.revature.bank_p0a.menus.dashboardMenus.DashboardMenu;
import com.revature.bank_p0a.menus.dashboardMenus.BankAccountCreationMenu;
import com.revature.bank_p0a.menus.dashboardMenus.ViewBankAccountsMenu;
import com.revature.bank_p0a.menus.dashboardMenus.BankAccountMenu;
import com.revature.bank_p0a.menus.startPages.LoginMenu;
import com.revature.bank_p0a.menus.startPages.RegisterMenu;
import com.revature.bank_p0a.menus.startPages.WelcomeMenu;
import com.revature.bank_p0a.services.BankAccountService;
import com.revature.bank_p0a.services.CustomerService;
import com.revature.bank_p0a.util.logging.Logger;
import com.revature.bank_p0a.menus.dashboardMenus.*;

public class AppState {

	private final Logger logger;
	private static boolean isRunning;
	private final MenuRouter router;
	
	public AppState() {
		
		logger = Logger.getLogger(true);
		logger.log("Application is initiliazing.....");
		
		isRunning = true;
		router = new MenuRouter();
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		CustomerDAO customerDAO = new CustomerDAO();
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		CustomerService customerService = new CustomerService(customerDAO);
		BankAccountService bankAccountService = new BankAccountService(bankAccountDAO, customerService);
		
		router.addMenu(new WelcomeMenu(consoleReader, router));
		router.addMenu(new RegisterMenu(consoleReader, router, customerService));
		router.addMenu(new LoginMenu(consoleReader, router, customerService));
		router.addMenu(new DashboardMenu(consoleReader, router, customerService));
		router.addMenu(new BankAccountMenu(consoleReader, router, bankAccountService));
		router.addMenu(new BankAccountCreationMenu(consoleReader, router, bankAccountService));
		router.addMenu(new ViewBankAccountsMenu(consoleReader, router, bankAccountService));
		router.addMenu(new DepositMenu(consoleReader, router, bankAccountService));
		router.addMenu(new WithdrawalMenu(consoleReader, router, bankAccountService));
		
		logger.log("Application initiliazed.");
	}
	
	public void startup() {
		try {
			while(isRunning) {
				router.transfer("/welcome");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void shutdown() {
		isRunning = false;
	}
}
	

