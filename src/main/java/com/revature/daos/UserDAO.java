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

public class UserDAO implements IUserDAO {
	
	public List<Account> findUserAccounts(User u) {
		try(Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM accounts WHERE user_id_fk ="+u.getUserID()+";";
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
					a.setUser(this.findByID(result.getInt("user_id_fk")));
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
	public List<User> findAll() {
		try(Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM users;";
			Statement statement = conn.createStatement();
			List<User> list = new ArrayList<>();
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				User u = new User();
				u.setUserID(result.getInt("user_id")); 
				u.setUsername(result.getString("username"));
				u.setPassword(result.getString("user_password"));
				u.setType(result.getInt("user_type"));
				u.setFirstName(result.getString("first_name"));
				u.setLastName(result.getString("last_name"));
				list.add(u);
				
			}
			return list;
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
				User u = new User();
				u.setUserID(result.getInt("user_id")); 
				u.setUsername(result.getString("username"));
				u.setPassword(result.getString("user_password"));
				u.setType(result.getInt("user_type"));
				u.setFirstName(result.getString("first_name"));
				u.setLastName(result.getString("last_name"));
//				System.out.println("user in find by id: " + u);
				return u;
			} else {
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public User findByUsername(String username) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM users WHERE username = ?;";			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				User u = new User();
				u.setUserID(result.getInt("user_id")); 
				u.setUsername(result.getString("username"));
				u.setPassword(result.getString("user_password"));
				u.setType(result.getInt("user_type"));
				u.setFirstName(result.getString("first_name"));
				u.setLastName(result.getString("last_name"));
				return u;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean addUser(User u) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "INSERT INTO users (username, user_password, user_type, first_name, last_name)"
					+ "VALUES (?, ?, ?, ?, ?);";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, u.getUsername());
			statement.setString(++index, u.getPassword());
			statement.setInt(++index, u.getType());
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
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
			String sql = "UPDATE users SET username = ?, password = ?, type = ?, first_name = ?, last_name = ?, WHERE user_id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, u.getUsername());
			statement.setString(++index, u.getPassword());
			statement.setInt(++index, u.getType());
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
			
			statement.setInt(++index, u.getUserID());
			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean deleteUser(int user_id) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "DELETE FROM users WHERE user_id =" + user_id + ";";
			Statement statement = conn.createStatement();
			statement.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}