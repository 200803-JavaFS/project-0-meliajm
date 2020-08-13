package com.revature.models;

import java.io.Serializable;

public class Account implements Serializable {
	
	private static final long serialVersionIUD = 1L;
	
	private int accountID;
	private double balance;
	private boolean statusOfAccount;
	private String type;
	private User userID;
	
	// Account has a User
	
	public Account() {
		super();
	}
	// constructor for homebase?
	public Account(String type) {
		super();
		this.balance = 0.00;
		this.statusOfAccount = true;
		this.type = type;
		this.userID = userID
	}
	
	
	
	
//	public Account() {
//		super();
//		balance = 0.00;
//		statusOfAccount = true;
//		// set id for account too
//	}
//	
//	public Account() {
//		super();
//	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// getter for balance
	public double getBalance() {
		return balance;
	}

	//  setter for balance
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public boolean getStatusOfAccount() {
		return statusOfAccount;
	}
	
	// only access for employees need to add  so that only employee can do that
	public void setStatusOfAccount(boolean statusOfAccount) {
		if (User.getType() == 2 || User.getType() == 3) {
			// need extra validation here? for True or False
			this.statusOfAccount = statusOfAccount;
			System.out.println("The status of your account is " + this.statusOfAccount);
		} 
	}
	
	// admin can cancel account
	public void cancelAccount(boolean statusOfAccount) {
		if (User.getType() == 3) {	
			// need to delete from database
			System.out.println("Your account has been deleted");
		} 
	}
	
//	public double deposit(double a) {
//		return this.balance;
//	}
//	
//	public double withdraw(double a) {
//		return this.balance;
//	}
//	
//	public double transfer(double a, String s) {
//		return this.balance;
//	}
	


	public int getAccountId() {
		return accountID;
	}

	public void setAccountId(int accountID) {
		this.accountID = accountID;
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
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (statusOfAccount ? 1231 : 1237);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
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
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (statusOfAccount != other.statusOfAccount)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [balance=\" + balance + \", type=\" + type + \"]";
	}

}
