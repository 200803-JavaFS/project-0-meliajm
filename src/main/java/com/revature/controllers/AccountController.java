package com.revature.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.daos.AccountDAO;
import com.revature.daos.IAccountDAO;
import com.revature.daos.IUserDAO;
import com.revature.daos.UserDAO;

public class AccountController {

	private static IAccountDAO dao = new AccountDAO();
	private static IUserDAO uDao = new UserDAO();
	private static final Logger log = LogManager.getLogger(AccountController.class);
	
	public List<Account> findAll() {
		log.info("Retrieving all accounts");
		List<Account> list = dao.findAll();
		
		// what goes here?
		for (Account a: list) {
			System.out.println("account :" + a);
		}
		return list;
	}
	
	public Account findByID(int id) {
		log.info("finding account with id " +id);
		return dao.findByID(id);
	}
	
	public boolean updateAccount(Account a) {
		log.info("Updating account "+ a);
		if (dao.updateAccount(a)) {
			return true;
		}
		return false;
	}
	
	public boolean insertAccount(Account a) {
		if (a.getUser() != null) {
			List<User> list = uDao.findAll();
			log.info("list in insert account: "+ list);
			boolean b = false;
			for (User u: list) {
				if (u.equals(a.getUser())) {
					b = true;
				}
			}
			if (b) {
				log.info("Adding account: " + a);
				if (dao.addAccount(a)) {
					return true;
				}
			} else {
				log.info("Adding account: " + a + "with a new User:" + a.getUser());
				if (dao.addAccountWithUser(a)) {
					return true;
				}
			}
		} else {
			log.info("Adding account: " + a);
			if (dao.addAccount(a)) {
				return true;
			}
		}
		return false;
	}
	
//	public boolean removeAccount(int id) {
//		log.info(", message, p0, p1, p2, p3, p4, p5, p6, p7);
//	}
	
	public static double deposit(Account a, double amount) {
		if (amount <= 0) {
			System.out.println("You must deposit a positive value.");
			return a.getBalance();
		} else {
			// add to balance
			System.out.println("You made a deposit.");
			return a.getBalance() + amount;
		}
	}
	
	public static double withdraw(Account a, double amount) {
		if (amount <= 0) {
			System.out.println("You must withdraw a positive value.");
			return a.getBalance();
		} else if (a.getBalance() - amount >= 0) {			
			System.out.println("You made a withdraw.");
			return a.getBalance() - amount;
		} else {
			System.out.println("You cannot over-withdraw from your account.");			
			return a.getBalance();
		}
	}
	
	public static double transfer(Account a, double amount, String accountName) {
		if (amount <= 0) {
			System.out.println("You can only transfer a positive amount.");
			return a.getBalance();
		} else if (a.getBalance() - amount >= 0) {			
			System.out.println("You made a transfer to " + accountName + ".");
			return a.getBalance() - amount;
		} else {
			System.out.println("You cannot transfer that amount based on the current balance of your account.");
			return a.getBalance();
		}
	}

}
