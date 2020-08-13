package com.revature;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.controllers.AccountController;
import com.revature.daos.AccountDAO;
import com.revature.models.Account;
import com.revature.utils.ConsoleUtil;

public class Driver {
	
	private static AccountDAO dao = new AccountDAO();
	
	public static void main(String[] args) {
		
		ConsoleUtil cons = new ConsoleUtil();
		cons.beginApp();
//		List<Account> list = dao.findAll();
//		
//		for (Account a: list) {
//			System.out.println(a);
//		}
//		
//		Account a = new Account(0.00, "Savings")
	}
	
//	private static final Logger log = LogManager.getLogger(Driver.class);
//	
//	private static AccountController ac = new AccountController();
//
//	public static void main(String[] args) {
//		log.info("The application has started");
//		try {
//			recur();
//		} catch(Error e) {
//			Log.error("Oh no we encountered an error");
//		}
//		Account a = ac.findAccountById(1);
//		log.info("we have found acount: "+a);
//		log.info("the end of app");
//	}
//	public Driver() {		                                   
//	}
	
//	public static void recur() {
//		recur();
//	}
	

}
