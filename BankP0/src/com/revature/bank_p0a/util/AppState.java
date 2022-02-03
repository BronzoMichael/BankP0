package com.revature.bank_p0a.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.bank_p0a.menus.LoginMenu;
import com.revature.bank_p0a.menus.RegisterMenu;
import com.revature.bank_p0a.menus.WelcomeMenu;
import com.revature.bank_p0a.services.ScientistService;

public class AppState {

	private static boolean isRunning;
	private final MenuRouter router;
	
	public AppState() {
		isRunning = true;
		router = new MenuRouter();
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		CustomerService customerService = new CustomerService();
		router.addMenu(new WelcomeMenu(consoleReader, router));
		router.addMenu(new RegisterMenu(consoleReader, router, customerService));
		router.addMenu(new LoginMenu(consoleReader, router, customerService));
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

