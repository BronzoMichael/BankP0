package com.revature.bank_p0a;



import com.revature.bank_p0a.util.AppState;

public class MainDriver {

	public static void main(String[] args) {
		AppState app = new AppState();
		app.startup();
	}
}

		
		/*
		 * New menus to implement
		 
		 * public static void checkBalance() throws IOException{
		 
			//Will return current balance in account
			//Then will ask would you like to make another transaction
			//send you back to manageAccount()
		}
		
		public static void withdrawCash() throws IOException{
			//Print "You have an available balance of: "
			//Ask how much hey want to withdraw(allow down to the $1)
			//check to make sure they do not overdraft. If they do, print an error message and ask them to enter a different amount or exit
			//If amount is valid:
			//Say something like "thanks, please take your cash below
			//Update current balance
			//send them back to manageAccount()
			
		}
		
		public static void depositCash() throws IOException{
			//Ask how much they would like to deposit
			//Print line saying something like please put cash in the machine
			//Say something like Thanks! You have deposited $20. 
			//Update current balance
			//send back to manageAccount()
			
		}
		*/

