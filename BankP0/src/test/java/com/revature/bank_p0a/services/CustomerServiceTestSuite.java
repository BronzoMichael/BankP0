package com.revature.bank_p0a.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.bank_p0a.daos.CustomerDAO;
import com.revature.bank_p0a.exceptions.InvalidRequestException;
import com.revature.bank_p0a.exceptions.ResourcePersistenceException;
import com.revature.bank_p0a.models.Customer;


public class CustomerServiceTestSuite {
	
	CustomerService sut;
	CustomerDAO mockCustomerDAO;
	
	@Before
	public void testPrep() {
		mockCustomerDAO = mock(CustomerDAO.class);
		sut = new CustomerService(mockCustomerDAO);
	}
	
	@Test
	public void test_isScientistValid_returnsTrue_givenValidUser() {
		
		// Arrange
		Customer validScientist = new Customer("valid","valid","valid","valid","valid");
		
		// Act
		boolean actualResult = sut.isCustomerValid(validCustomer);
		
		// Assert
		Assert.assertTrue(actualResult);
		
	}
	
	@Test
	public void test_isCustomerValid_returnsFalse_givenUserWithFirstName() {
		
		// Arrange
		Customer invalidCustomer1 = new Customer("","valid","valid","valid","valid");
		Customer invalidCustomer2 = new Customer(null,"valid","valid","valid","valid");
		Customer invalidCustomer3 = new Customer("         ","valid","valid","valid","valid");
		
		
		//Act
		boolean actualResult1 = sut.isCustomerValid(invalidCustomer1);
		boolean actualResult2 = sut.isCustomerValid(invalidCustomer2);
		boolean actualResult3 = sut.isCustomerValid(invalidCustomer3);
		
		//Assert - everything you assert must pass the condition
		Assert.assertFalse(actualResult1);
		Assert.assertFalse(actualResult2);
		Assert.assertFalse(actualResult3);
		
	}
	
	//TODO: Figure out implementation. CHARLES YOU DINGLEBERRY MOCK IT!!!!!!!
	@Test
	public void test_registerScientist_returnsTrue_givenValidCustomer() {
		// Arrange
		Customer validCustomer = new Customer("valid","valid","valid","valid","valid");
		when(mockCustomerDAO.findByUsername(validCustomer.getUsername())).thenReturn(null);
		when(mockCustomerDAO.findByEmail(validCustomer.getEmail())).thenReturn(null);
		when(mockCustomerDAO.create(validCustomer)).thenReturn(validCustomer);
		
		// Act
		Customer actualResult = sut.registerNewScientist(validScientist);
		
		// Assert
		Assert.assertNotNull(actualResult);
		verify(mockCustomerDAO, times(1)).create(validCustomer);
	}

	@Test(expected = InvalidRequestException.class)
	public void test_registerCustomer_throwsInvalidRequestException_givenInvalidUser() {
		sut.registerNewCustomer(null);
	}
	
	@Test(expected = ResourcePersistenceException.class)
	public void test_registerCustomer_throwsResourcePersistenceException_givenCustomerWithTakenUsername() {
		
		// Arrange
		Customer usernameTakenCustomer = new Customer("valid","valid","valid","valid","valid");
		when(mockCustomerDAO.findByUsername(usernameTakenCustomer.getUsername())).thenReturn(usernameTakenCustomer);
		when(mockCustomerDAO.findByEmail(usernameTakenCustomer.getEmail())).thenReturn(null);
		when(mockCustomerDAO.create(usernameTakenCustomer)).thenReturn(usernameTakenCustomer);
		
		// Act
		try {
			sut.registerNewCustomer(usernameTakenCustomer);
		} finally {
			// Assert
			verify(mockCustomerDAO, times(0)).create(usernameTakenCustomer);
		}
	}
		
		@Test(expected = ResourcePersistenceException.class)
		public void test_registerScientist_throwsResourcePersistenceException_givenCustomerWithTakenEmail() {
			
			// Arrange
			Customer emailTakenCustomer = new Customer("valid","valid","valid","valid","valid");
			when(mockCustomerDAO.findByUsername(emailTakenCustomer.getUsername())).thenReturn(null);
			when(mockCustomerDAO.findByEmail(emailTakenCustomer.getEmail())).thenReturn(emailTakenCustomer);
			when(mockCustomerDAO.create(emailTakenCustomer)).thenReturn(emailTakenCustomer);
			
			// Act
			try {
				sut.registerNewCustomer(emailTakenCustomer);
			} finally {
				// Assert
				verify(mockCustomerDAO, times(0)).create(emailTakenCustomer);
			}
		
		
	}
}
