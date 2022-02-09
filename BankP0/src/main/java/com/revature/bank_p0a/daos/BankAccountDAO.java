package com.revature.bank_p0a.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.revature.bank_p0a.models.BankAccount;
import com.revature.bank_p0a.models.Customer;
import com.revature.bank_p0a.util.List;
import com.revature.bank_p0a.util.ConnectionFactory;
import com.revature.bank_p0a.util.LinkedList;

public class BankAccountDAO implements CrudDAO<BankAccount> {
	
	// TODO: Implement search by creatorID
	public List<BankAccount> findBankAccountByOwnerId(String id){
		return null;
	}

	@Override
	public BankAccount create(BankAccount newBankAccount) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			newBankAccount.setBankAccountId(UUID.randomUUID().toString());

			String sql = "insert into bank_accounts (bank_account_id, bank_account_name, available_funds, owner_id) values (?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, newBankAccount.getBankAccountId());
			ps.setString(2, newBankAccount.getBankAccountName());
			ps.setDouble(3, newBankAccount.getAvailableFunds());
			ps.setString(4, newBankAccount.getOwner().getCustomerId());

			int rowsInserted = ps.executeUpdate();

			if (rowsInserted != 0) {
				return newBankAccount;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}
	
	public BankAccount findByBankAccountName(String bankAccountName) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from bank_accounts where bank_account_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bankAccountName);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BankAccount bankAccount = new BankAccount();
				bankAccount.setBankAccountId(rs.getString("bank_account_id"));
				bankAccount.setBankAccountName(rs.getString("bank_account_name"));
				bankAccount.setAvailableFunds(rs.getDouble("available_funds"));

				return bankAccount;
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		
		return null;
	}

	@Override
	public List<BankAccount> findAll() {
		
		List<BankAccount> bankAccountsList = new LinkedList<>(); 
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from bank_accounts";
			Statement s = conn.createStatement();
			
			ResultSet resultSet = s.executeQuery(sql);
			
			
			while(resultSet.next()) {
				BankAccount bankAccount = new BankAccount();
				bankAccount.setBankAccountId(resultSet.getString("bank_account_id"));
				bankAccount.setBankAccountName(resultSet.getString("bank_account_name"));
				bankAccount.setAvailableFunds(resultSet.getDouble("available_funds"));
				
				bankAccountsList.add(bankAccount);
			}	
			
			return bankAccountsList;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public BankAccount findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean update(String bankAccountId, double updatedBalance) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "update bank_accounts set available_funds = ? where bank_account_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, updatedBalance);
			ps.setString(2, bankAccountId);
			ps.executeUpdate();

			return true;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
		return false;
	}
	
	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(BankAccount updatedObj) {
		// TODO Auto-generated method stub
		return false;
	}

}
