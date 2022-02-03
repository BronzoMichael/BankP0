package com.revature.bank_p0a.menus;

import java.io.BufferedReader;

import com.revature.bank_p0a.util.MenuRouter;
import static com.revature.bank_p0a.util.AppState.shutdown;

public class WelcomeMenu extends Menu{

	public WelcomeMenu(BufferedReader consoleReader, MenuRouter router) {
		super("Welcome", "/welcome", consoleReader, router);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		
		System.out.print(
				"Welcome to Bank of Bronzo!\n" + "1) Login\n" + "2) Register\n" + "3) Exit\n" + "> ");
		
		String userSelection = consoleReader.readLine();

		switch (userSelection) {
		case "1":
			router.transfer("/login");
			break;
		case "2":
			router.transfer("/register");
			break;
		case "3":
			shutdown();
			break;
		default:
			System.out.println("Invalid Request");
			break;
		}
		
	}