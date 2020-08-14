package com.revature.daos;

import java.util.List;

import com.revature.models.Account;

public interface IAccountDAO {
	
	public List<Account> findAll();
	public Account findByID(int id);
	public boolean addAccount(Account a);

}
