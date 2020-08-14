package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.models.Account;
import com.revature.utils.ConnectionUtility;

public class UserDAO implements IUserDAO {
	
	private IAccountDAO aDao = new AccountDAO();

	@Override
	public List<User> findAll() {
		
		try(Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM users;";
			Statement statement = conn.createStatement();
			List<User> list = new ArrayList<>();
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				User u = new User(result.getInt("user_id"), 
						result.getString("username"),
						result.getString("user_password"),
						result.getInt("user_type"),
						result.getString("first_name"),
						result.getString("last_name"),
						null);
				// question
				if (result.getInt("account_id_fk")!=0) {
					u.setAccountBase(aDao.findByID(result.getInt("account_id_fk")));
					
				}
				list.add(u);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findByID(int id) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM users WHERE user_id ="+id+";";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			if (result.next()) {
				User u = new User(result.getInt("user_id"), 
						result.getString("username"),
						result.getString("user_password"),
						result.getInt("user_type"),
						result.getString("first_name"),
						result.getString("last_name"),
						null);
				// question
				if (result.getInt("account_id_fk")!=0) {
					u.setAccountBase(aDao.findByID(result.getInt("account_id_fk")));
					
				}
				return u;
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(User u) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "INSERT INTO users (username, user_password, user_type, first_name, last_name, account_id_fk)"
					+ "VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setInt(++index, u.getUserID());
			statement.setString(++index, u.getUsername());
			statement.setString(++index, u.getPassword());
			statement.setInt(++index, u.getType());
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
			if(u.getAccountBase()!=null) {
				Account a = u.getAccountBase();
				statement.setInt(++index, a.getAccountID());
			} else {
				// question
				statement.setInt(++index, 0);
			}
			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUser(User u) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE users SET username = ?, password = ?, type = ?, first_name = ?, last_name = ?, account_id_fk = ? WHERE user_id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, u.getUsername());
			statement.setString(++index, u.getPassword());
			statement.setInt(++index, u.getType());
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
			if(u.getAccountBase()!=null) {
				Account a = u.getAccountBase();
				statement.setInt(++index, a.getAccountID());
			} else {
				// question
				statement.setInt(++index, 0);
			}
			statement.setInt(++index, u.getUserID());
			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "DELETE * FROM users WHERE user_id ="+id +";";
			Statement statement = conn.createStatement();
			statement.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean addUserWithAccount(User u) {
		try (Connection conn = ConnectionUtility.getConnection()){
			
			String sql = "BEGIN; "
					+ "INSERT INTO accounts (account_id, balance, status_of_account, account_type)"
					+ "VALUES (?, ?, ?, ?);"
					+ "INSERT INTO users (username, user_password, user_type, first_name, last_name, account_id_fk)"
					+ "VALUES (?, ?, ?, ?, ?, ?);"
					+ "COMMIT;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			Account a = u.getAccountBase();
			
			int index = 0;
			statement.setInt(++index, a.getAccountID());
			statement.setDouble(++index, a.getBalance());
			statement.setInt(++index, a.getStatusOfAccount());
			statement.setString(++index, a.getAccountType());
			statement.setString(++index, u.getUsername());
			statement.setString(++index, u.getPassword());
			statement.setInt(++index, u.getType());
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
			statement.setInt(++index, a.getAccountID());
			
			statement.execute();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
