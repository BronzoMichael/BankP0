package com.revature.bank_p0a.menus.startPages;

import java.io.BufferedReader;

import com.revature.bank_p0a.exceptions.InvalidRequestException;
import com.revature.bank_p0a.menus.Menu;
import com.revature.bank_p0a.models.Customer;
import com.revature.bank_p0a.services.CustomerService;
import com.revature.bank_p0a.util.MenuRouter;

public class RegisterMenu extends Menu {

	CustomerService customerService;

	public RegisterMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super("Register", "/register", consoleReader, router);
		this.customerService = customerService;
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
				System.out.println("The User selected Register");

				// Things to obtain from user: first name, last name, email,username, password

				System.out.println("Please provided us with some basic information");
				System.out.print("First Name: ");
				String firstName = consoleReader.readLine();

				System.out.print("Last Name: ");
				String lastName = consoleReader.readLine();

				System.out.print("Email: ");
				String email = consoleReader.readLine();

				System.out.print("Username: ");
				String username = consoleReader.readLine();

				System.out.print("Password: ");
				String password = consoleReader.readLine();

				Customer customer = new Customer(firstName, lastName, email, username, password);

				try {
					customerService.registerNewCustomer(customer);
					System.out.println("Thank you for registering!");
				} catch (InvalidRequestException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace(); 
					System.out.println("YOU HAVE PROVIDED INVALID DATA PLEASE TRY AGAIN\n\n\n");

					router.transfer("/welcome");
				}
			}
		
	}