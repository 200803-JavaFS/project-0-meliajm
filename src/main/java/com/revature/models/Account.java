package com.revature.models;

import java.io.Serializable;

public class Account implements Serializable {
	
	// how are we using this serial? 
	private static final long serialVersionIUD = 1L;
	
	private int accountID;
	private double balance;
	private int statusOfAccount; // changed from boolean to int
	private String accountType;
		
	public Account() {
		super();
	}
	// constructor for homebase?
	// all getters and setters?
	public Account(int accountID, double balance, int statusOfAccount, String accountType) {
		super();
		this.accountID = accountID;
		this.balance = balance;
		this.statusOfAccount = statusOfAccount;
		this.accountType = accountType;		
	}
	
	public Account(double balance, int statusOfAccount, String accountType) {
		super();
		this.balance = balance;
		this.statusOfAccount = statusOfAccount;
		this.accountType = accountType;		
	}
	
	public int getAccountID() {
		return accountID;
	}
	
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	//  admin can set this setter for balance
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public int getStatusOfAccount() {
		return statusOfAccount;
	}
	
	// only access for employees need to add  so that only employee can do that
	public void setStatusOfAccount(int statusOfAccount, User u) {
		if (u.getType() == 2 || u.getType() == 3) {
			// need extra validation here? for True or False
			this.statusOfAccount = statusOfAccount;
			
			System.out.println("The status of your account is " + this.statusOfAccount);
		} 
	}
	
	// admin can cancel account
	public void cancelAccount(boolean statusOfAccount, User u) {
		if (u.getType() == 3) {	
			// need to delete from database
			System.out.println("Your account has been deleted");
		} 
	}
	
	
	
	public void approveAccount() {
		// this is basically where the constructor should go
		// i think
		// no this is where employee and admin can modify account status
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountID;
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + statusOfAccount;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountID != other.accountID)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (statusOfAccount != other.statusOfAccount)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", balance=" + balance + ", statusOfAccount=" + statusOfAccount
				+ ", accountType=" + accountType + "]";
	}
	
	
	
	
	
	
	
	

}
