package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.utils.ConnectionUtility;

public class AccountDAO implements IAccountDAO {

	private IUserDAO uDao = new UserDAO();


	@Override
	public List<Account> findAll() {
		
		try(Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM accounts;";
			Statement statement = conn.createStatement();
			
			List<Account> list = new ArrayList<>();
			
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()) {
				Account a = new Account(
						result.getInt("account_id"),
						result.getDouble("balance"),
						result.getInt("status_of_account"),
						result.getString("account_type"),
						null);
				if (result.getInt("user_id_fk")!=0) {
					a.setUser(uDao.findByID(result.getInt("user_id_fk")));
				}
				list.add(a);

			}
			return list;
					
				
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account findByID(int id) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM accounts WHERE account_id =" + id + ";";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			if (result.next()) {
				Account a = new Account(result.getInt("account_id"),
										result.getDouble("balance"),
										result.getInt("status_of_account"),
										result.getString("account_type"),
										null);
				if (result.getInt("user_id_fk") != 0) {
					a.setUser(uDao.findByID(result.getInt("user_id_fk")));
				}
				return a;
				
			} 
		} catch(SQLException e) {
//			log.warn(e)
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addAccount(Account a) {
		
		try(Connection conn = ConnectionUtility.getConnection()) {
			String sql = "INSERT INTO accounts (balance, status_of_account, account_type, user_id_fk)"
					+ "VALUES (?, ?, ?, ?);";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setDouble(++index, a.getBalance());
			statement.setInt(++index, a.getStatusOfAccount());
			statement.setString(++index, a.getAccountType());
			if (a.getUser()!=null) {
				User u = a.getUser();
				statement.setInt(++index, u.getUserID());
			} else {
				// null or 0
				statement.setInt(++index, 0);
			}
			
			statement.execute();
			return true;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean updateAccount(Account a) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE accounts SET balance = ?,"
					+ " status_of_account = ?,"
					+ " account_type= ?, "
					+ " user_id_fk = ? WHERE account_id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setDouble(++index, a.getBalance());
			statement.setInt(++index, a.getStatusOfAccount());
			statement.setString(++index, a.getAccountType());
			if(a.getUser()!=null) {
				User u = a.getUser();
				statement.setInt(++index, u.getUserID());
			}else {
				statement.setInt(++index, 0);
			}
			statement.setInt(++index, a.getAccountID());
			
			statement.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean addAccountWithUser(Account a) {
		try (Connection conn = ConnectionUtility.getConnection()){
			
			String sql = "BEGIN; "
					+ "INSERT INTO users (user_id, username, user_password, user_type, first_name, last_name)"
					+ "VALUES (?, ?, ?, ?, ?, ?);"
					+ "INSERT INTO accounts (balance, status_of_account, account_type, user_id_fk)"
					+ "VALUES (?, ?, ?, ?, ?);"
					+ "COMMIT;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			User u = a.getUser();
			
			int index = 0;
			statement.setInt(++index, u.getUserID());
			statement.setString(++index, u.getUsername());
			statement.setString(++index, u.getPassword());
			statement.setInt(++index, u.getType());
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
			statement.setDouble(++index, a.getBalance());
			statement.setInt(++index, a.getStatusOfAccount());
			statement.setString(++index, a.getAccountType());
			statement.setInt(++index, u.getUserID());
			
			statement.execute();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	

}
