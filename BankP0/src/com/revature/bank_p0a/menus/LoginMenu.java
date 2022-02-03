package com.revature.bank_p0a.menus;

import java.io.BufferedReader;

import com.revature.bank_p0a.services.CustomerService;
import com.revature.bank_p0a.util.MenuRouter;

public class LoginMenu extends Menu {

	private final CustomerService customerService;

	public LoginMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerSerivce) {
		super("Login", "/login", consoleReader, router);
		this.customerService = customerSerivce;
	}

	@Override
	public void render() throws Exception {
		 System.out.println("Please enter your account information");
	     System.out.print("Username: ");
	     String username = consoleReader.readLine();
	     System.out.print("Password: ");
	     String password = consoleReader.readLine();
	        
	        // Implement an authentication and successful login:
	     
	        System.out.println(customerService.getAllCustomers());
	        
	}
