package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
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
						result.getString("password"),
						result.getInt("type"),
						result.getString("first_name"),
						result.getString("last_name"),
						null);
				// null
				if (result.getString("account_id_fk")!=null) {
					u.setAccountID(aDao.findByID(result.getInt("account_id_fk")));
					
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
			if (result.getString("account_id_fk")) {
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(User u) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "INSERT INTO users (user_id, username, password, type, first_name, last_name, account_id_fk)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setInt(++index, u.getUserID());
			statement.setString(++index, u.getUsername());
			statement.setString(++index, u.getPassword());
			statement.setInt(++index, u.getType());
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
			if(u.getAccount()!=null) {
				Account a = u.getAccount();
				statement.setInt(++index, a.getAccount());
			} else {
				statement.setInt(++index, null);
			}
			statement.execute();
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(User u) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE users SET user_id = ?, username = ?, password = ?, type = ?, first_name = ?, last_name = ?, account_id_fk = ? WHERE user_id = ?;";
			
PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setInt(++index, u.getUserID());
			statement.setString(++index, u.getUsername());
			statement.setString(++index, u.getPassword());
			statement.setInt(++index, u.getType());
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
			if(u.getAccount()!=null) {
				Account a = u.getAccount();
				statement.setInt(++index, a.getAccount());
			} else {
				statement.setInt(++index, null);
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

}
