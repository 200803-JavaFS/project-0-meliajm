package com.revature.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.Driver;
import com.revature.models.Account;
//import com.revature.repos.AccountDAO;

public class AccountController {
	
	private static final Logger log = LogManager.getLogger(AccountController.class);
	
//	private AccountDAO dao = new AccountDAO();
//	private static Account a = new Account();

//	public Account findAccountById(int i) {
//		log.info("logging in account controller");
////		return dao.findById(i);
//	}
	// make account instance?
	
	// account as argument for methods
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
