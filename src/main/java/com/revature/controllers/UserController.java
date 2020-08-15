package com.revature.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.IUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Account;
import com.revature.models.User;

public class UserController {
	
	private static IUserDAO dao= new UserDAO();
	
	private static final Logger log = LogManager.getLogger(UserController.class);

	public List<Account> findUserAccounts(User u) {
		log.info("Retrieving user accounts");
		return dao.findUserAccounts(u);
	}
	
	public List<User> findAll() {
		log.info("Retrieving all users");
		return dao.findAll();
	}
	
	public User findByID(int id) {
		log.info("finding a user with id " +id);
		return dao.findByID(id);
	}
	
	public User findByUsername(String username) {
		log.info("finding a user with username " +username);
		return dao.findByUsername(username);
	}
	
	public boolean updateUser(User u) {
		log.info("updating a user: " + u);
		if (dao.updateUser(u)) {
			return true;
		} 
		return false;
	}
	
	public boolean insertUser(User u) {
		log.info("adding a user: " + u);

		if (dao.addUser(u)) {
			return true;
		}
		return false;
	}
	
//	public boolean removeUser(int id) {
//		log.info("deleting a user: " + u);
//
//		if (dao.deleteUser(id)) {
//			return true;
//		}
//		return false;
//	}
	
	
	
	// make login method

//	private UserDAO dao = new UserDAO();
	// instance of user

//	public User findUserById(int i) {
//		log.info("logging in user controller");
//		return dao.findById(i);
//		
//	}

}

