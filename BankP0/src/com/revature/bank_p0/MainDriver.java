package com.revature.bank_p0;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.revature.bank_p0.models.Customer;

public class MainDriver {



		static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

		public static void main(String[] args) {
			boolean isRunning = true;
			while (isRunning) {
				System.out.println(
						"Welcome to the Bronzo Bank!\n" + "1) Login\n" + "2) Register\n" + "3) Exits\n" + "> ");

				// BufferedReader consoleReader = new BufferedReader(new
				// InputStreamReader(System.in));

				// Try block - is used to test risky code
				try {
					String userSelection = consoleReader.readLine();

//					if (userSelection.equals("1")) {
//						System.out.println("The user selected login");
//					} else if (userSelection.equals("2")) {
//						System.out.println("The user selected Register");
//					} else if (userSelection.equals("3")) {
//						System.out.println("The user selected Exit! Now exiting....");
//					} else if (userSelection.equals("4")) {
//						throw new IOException("Stack example.");
//					} else {
//						System.out.println("What on earth are you trying to tell me to do?!?!");
//					}

//					Scientist example = new Scientist("Charles", "Jester", "JesterCharles@mail.com", "jestchar", "superPassword");
//					System.out.println(example);

					switch (userSelection) {
					case "1":
						login();
						break;
					case "2":
						register();
						break;
					case "3":
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

//			
				// main(args); DO NOT USE -- Stack memory will get STACKED!!!!
				}
			try {
				consoleReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public static void register() throws IOException {

			System.out.println("The user selected register! ");

			System.out.println("Please provide us with some basic information");
			System.out.print("First Name: ");
			String fname = consoleReader.readLine();

			System.out.print("Last Name: ");
			String lname = consoleReader.readLine();

			System.out.print("Email: ");
			String email = consoleReader.readLine();

			System.out.print("Username: ");
			String username = consoleReader.readLine();

			System.out.print("Password: ");
			String password = consoleReader.readLine();

			// System.out.printf("Provided input: First Name: %s, Last Name: %s!, Email: %s, Username: %s, Password: %s", fname, lname, email, username, password);

			// Scientist scientist = new Scientist("Charles", "Jester", "JesterCharles@mail.com", "jestchar", "superPassword");
			Customer customer = new Customer(fname, lname, email, username, password);
			File customerPersistance = new File("resources/data.txt");
			
			// Try-with-resources, usable with any class that implements Closeable
			try(FileWriter fileWriter = new FileWriter(customerPersistance, true); ){// Include true to append the data	
				fileWriter.write(customer.toFileString() + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String[] customerArr = customer.toFileString().split(":");
		
			customer.printFromFile(customerArr);
		}
		
		public static void login() throws IOException {

			System.out.println("The user selected login! ");

			System.out.println("Please enter your username.");
			System.out.print("Username: ");
			String fusername = consoleReader.readLine();

			System.out.print("Please enter your password: ");
			String lpassword = consoleReader.readLine();

// scan through collection of registered users and look for matching username and password
		}

	}


