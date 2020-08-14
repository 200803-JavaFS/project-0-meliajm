package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.utils.ConnectionUtility;

public class AccountDAO implements IAccountDAO {

	@Override
	public List<Account> findAll() {
		
		try(Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM accounts;";
			Statement statement = conn.createStatement();
			
			List<Account> list = new ArrayList<>();
			
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()) {
				Account a = new Account();
				a.setAccountID(result.getInt("account_id"));
				a.setAccountType(result.getString("account_type"));
				a.setBalance(result.getDouble("balance"));
				a.setStatusOfAccount(result.getInt("account_type"));
				list.add(a);
			}
			return list;
					
				
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
// /////////// come back to this
	@Override
	public Account findByID(int id) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM accounts WHERE account_id =" + id + ";";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			if (result.next()) {
				Account a = new Account(result.getInt("account_id"),
						result.getDouble("balance"), result.getInt("status_of_account"),
						result.getString("account_type"));
				return a;
				
			} else {
				// good place to log a failed query
				//log.warn()
				// still need this?
				return null;
			}
		} catch(SQLException e) {
//			log.warn(e)
		}
		return null;
	}

	@Override
	public boolean addAccount(Account a) {
		
		try(Connection conn = ConnectionUtility.getConnection()) {
			String sql = "INSERT INTO accounts (account_id, balance, status_of_account, account_type)"
					+ "VALUES (?, ?, ?, ?);";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setInt(++index, a.getAccountID());
			statement.setDouble(++index, a.getBalance());
			statement.setInt(++index, a.getStatusOfAccount());
			statement.setString(++index, a.getAccountType());
			
			statement.execute();
			return true;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
