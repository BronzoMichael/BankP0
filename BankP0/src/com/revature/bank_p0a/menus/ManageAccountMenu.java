package com.revature.bank_p0a.menus;

import java.io.BufferedReader;
import java.io.IOException;

import com.revature.bank_p0a.util.MenuRouter;

public class ManageAccountMenu extends Menu {

	

	public ManageAccountMenu(String name, String route, BufferedReader consoleReader, MenuRouter router) {
		super("ManageAccount", "/manageAccount", consoleReader, router);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.print("Welcome:");  //username goes here) 
		System.out.print("What would you like to do today?\n" + "1) Check Balance\n" + "2) Deposit Cash\n" + "3) Withdraw Cash\n" + "4) Exit\n" "> ");
		boolean isRunning = true;
		while (isRunning) {
		try {
				String userSelection = consoleReader.readLine();


				switch (userSelection) {
				case "1":
					//checkBalance();
					break;
				case "2":
					//depositCash();
					break;
				case "3":
					//withdrawCash();
				case "4":
					System.out.println(("The user selected Exit! Now exiting...."));
					isRunning = false;
					break;
				default:
					System.out.println("What on earth are you trying to tell me to do?!?!");
					break;
				}

				System.out.println("User selected: " + userSelection);

			} catch (IOException e) { // Catch block - catches any defined exceptions and handles according
				// TODO Auto-generated catch block
				e.printStackTrace(); // Stuff you don't write can be thrown in the stack, LOOK for what you wrote
				isRunning = false;
			} finally { // Something that runs at the end of every use case
				System.out.println("User finished selection");
			}
	}