package com.revature.bank_p0a.menus.dashboardMenus;

import java.io.BufferedReader;

import com.revature.bank_p0a.menus.Menu;
import com.revature.bank_p0a.models.Customer;
import com.revature.bank_p0a.services.CustomerService;
import com.revature.bank_p0a.util.MenuRouter;

public class DashboardMenu extends Menu {

	private final CustomerService customerService;

	public DashboardMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super("Dashboard", "/dashboard", consoleReader, router);
		this.customerService = customerService;
	}

	@Override
	public void render() throws Exception {

		Customer sessionCustomer = customerService.getSessionCustomer();

		if (sessionCustomer == null) {
			System.out.println("You are not currently logged in! Rerouting to the login screen.....");
			router.transfer("/login");
			return;
		}

		while (customerService.isSessionActive()) {
			System.out.println("Welcome " + sessionCustomer.getUsername());
			String menu = "1) Create bank account\n" + 
					"2) View my bank account\n" +
					"3) Make a transaction\n" + 
					"4) Logout\n" + 
					 "> ";

			System.out.print(menu);

			String userSelection = consoleReader.readLine();

			switch (userSelection) {
			case "1":
				System.out.println("Create bank account selected");
				router.transfer("/create-bankAccount");
				break;
			case "2":
				System.out.println("View My bank account selected:");
				router.transfer("/my-bankAccounts");
				break;
			case "3":
				System.out.println("Make a transaction");
				router.transfer("/bankAccount");
				break;
			case "4":
				customerService.logout();
				break;
			default:
				System.out.println("The user made an invalid selection");
			}
		}
	}

}