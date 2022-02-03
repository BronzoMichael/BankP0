package com.revature.bank_p0a.services;

import java.io.File;
import java.io.FileWriter;

import com.revature.bank_p0a.daos.CustomerDAO;
import com.revature.bank_p0a.exceptions.InvalidRequestException;
import com.revature.bank_p0a.models.Customer;
import com.revature.bank_p0a.util.List;

public class CustomerService {

	private CustomerDAO customerDao = new CustomerDAO();
	
	public boolean registerNewCustomer(Customer newCustomer) {
		if(!isCustomerValid(newCustomer)) {
			throw new InvalidRequestException("Invalid user data provider");
		}

		// TODO: Write logic that verifies the new users information isn't duplicated int he system
		customerDao.create(newCustomer);
		

		return true;
	}
	
	public List<Customer> getAllCustomers(){
		return customerDao.findAll();		
	}
	
	//TODO: Impelement authentication
	public Customer autenticateCustomer(String username, String password) {
		customerDao.findByUsernameAndPassword(username, password);
		return null;
	}

	public boolean isCustomerValid(Customer newCustomer) {
		if(newCustomer == null) return false;
		if(newCustomer.getFirstName() == null || newCustomer.getFirstName().trim().equals("")) return false;
		if(newCustomer.getLastName() == null ||newCustomer.getLastName().trim().equals("")) return false;
		if(newCustomer.getEmail() == null || newCustomer.getEmail().trim().equals("")) return false;
		if(newCustomer.getUsername() == null || newCustomer.getUsername().trim().equals("")) return false;
		return newCustomer.getPassword() != null || !newCustomer.getPassword().trim().equals("");


	}
	
}
