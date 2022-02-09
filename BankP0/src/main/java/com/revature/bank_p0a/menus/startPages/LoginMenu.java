package com.revature.bank_p0a.menus.startPages;

import java.io.BufferedReader;

import com.revature.bank_p0a.exceptions.AuthenticationException;
import com.revature.bank_p0a.menus.Menu;
import com.revature.bank_p0a.models.Customer;
import com.revature.bank_p0a.services.CustomerService;
import com.revature.bank_p0a.util.MenuRouter;
import com.revature.bank_p0a.util.List;

public class LoginMenu extends Menu {

	private final CustomerService customerService;

	public LoginMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerSerivce) {
		super("Login", "/login", consoleReader, router);
		this.customerService = customerSerivce;
	
	}

	@Override
	public void render() throws Exception {
		 System.out.println("Please enter your credentials for you account.");
	     System.out.print("Username: ");
	     String username = consoleReader.readLine();
	     System.out.print("Password: ");
	     String password = consoleReader.readLine();
	        
	     // Test for a select all
//	     List<Scientist> test = scientistService.getAllScientists();
//	     System.out.println(test.get(0));
	     // Implement an authentication and successful login:
	     try {
	    	 customerService.authenticateCustomer(username, password);
	    	 router.transfer("/dashboard");
	        } catch (AuthenticationException e) {
	            System.out.println("Incorrect credentials provided! No matching user account found.");
	        }
	     
	        
	}
}
