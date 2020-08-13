package com.revature;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.controllers.AccountController;
import com.revature.models.Account;

public class Driver {
	
	private static final Logger log = LogManager.getLogger(Driver.class);
	
	private static AccountController ac = new AccountController();

	public static void main(String[] args) {
		log.info("The application has started");
		
//		try {
//			recur();
//		} catch(Error e) {
//			Log.error("Oh no we encountered an error");
//		}
		
//		Account a = ac.findAccountById(1);
		
//		log.info("we have found acount: "+a);
		log.info("the end of app");
		
	}
//	public Driver() {		                                   
//	}
	
	public static void recur() {
		recur();
	}
	

}
