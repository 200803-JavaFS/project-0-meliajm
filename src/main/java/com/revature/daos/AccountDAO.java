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
			String sql = "SELECT * FROM accounts";
			Statement statement = conn.createStatement();
			
			List<Account> list = new ArrayList<>();
			
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()) {
				Account a = new Account();
				a.setName(result.getString("account_name"));
//				a.setBalance(result.getString("balance"));
//				a.setStatusOfAccount(result.getString("account_type"));
				list.add(a);
			}
			return list;
					
				
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	// find by ID instead of name
	public Account findByName(String name) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM accounts WHERE account_id = ?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				Account a = new Account();
				a.setName(result.getString("account_name"));
//				a.setBalance(result.getString("balance"));
//				a.setStatusOfAccount(result.getString("account_type"));
				return a;
				
			} else {
				// good place to log a failed query
				return null;
			}
		} catch(SQLException e) {
			
		}
		return null;
	}

	@Override
	public boolean addAccount(Account a) {
		// TODO Auto-generated method stub
		return false;
	}

}
