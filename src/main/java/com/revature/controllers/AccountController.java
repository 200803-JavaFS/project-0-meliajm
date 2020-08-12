package com.revature.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.Driver;
import com.revature.models.Account;
import com.revature.repos.AccountDAO;

public class AccountController {
	
	private static final Logger log = LogManager.getLogger(AccountController.class);
	
	private AccountDAO dao = new AccountDAO();

	public Account findAccountById(int i) {
		log.info("logging in account controller");
		return dao.findById(i);
		
	}

}
