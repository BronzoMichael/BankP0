package com.revature.bank_p0a.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.revature.bank_p0a.models.Customer;
import com.revature.bank_p0a.util.ConnectionFactory;
import com.revature.bank_p0a.util.LinkedList;
import com.revature.bank_p0a.util.List;

public class CustomerDAO implements CrudDAO<Customer> {


	// TODO: Implement Authentication
	public Customer findByUsernameAndPassword(String username, String password) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	// TODO: Implement FindByEmail
	public Customer findByEmail(String email) {
		return null;
	}
	
	// TODO: Implement FindByUsername
	public Customer findByUsername(String username) {
		return null;
	}

	@Override
	public Customer create(Customer newCustomer) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			newCustomer.setCustomerId(UUID.randomUUID().toString());
			
			String sql = "insert into customers (customer_id, first_name, last_name, email, username, password) values (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, newCustomer.getCustomerId());
			ps.setString(2, newCustomer.getFirstName());
			ps.setString(3, newCustomer.getLastName());
			ps.setString(4, newCustomer.getEmail());
			ps.setString(5, newCustomer.getUsername());
			ps.setString(6, newCustomer.getPassword());
			
			int rowsInserted = ps.executeUpdate();
			
			if(rowsInserted != 0) {
				return newCustomer;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	
	}

	@Override
	public List<Customer> findAll() {
		
		List<Customer> customersList = new LinkedList<>(); 
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from customers";
			Statement s = conn.createStatement();
			
			ResultSet resultSet = s.executeQuery(sql);
			
			
			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(resultSet.getString("scientist_id"));
				customer.setFirstName(resultSet.getString("first_name"));
				customer.setLastName(resultSet.getString("last_name"));
				customer.setEmail(resultSet.getString("email"));
				customer.setUsername(resultSet.getString("username"));
				customer.setPassword(resultSet.getString("password"));
				
				customersList.add(customer);
			}	
			
			return customersList;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Customer findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Customer updatedObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
