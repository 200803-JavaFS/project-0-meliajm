package com.revature.daos;

import java.util.List;

import com.revature.models.Account;

public interface IAccountDAO {
	
	public List<Account> findAll();
	public Account findByName(String name);
	public boolean addAccount(Account a);

}
