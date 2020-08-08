package com.revature.models;

public class Account {
	
	private double balance;
	private boolean statusOfAccount;
	private int id;
	// Account has a User
	
	public Account() {
		balance = 0.00;
		statusOfAccount = true;
		// set id for account too
	}	
	
	// setter for balance
	public double getBalance() {
		return balance;
	}

	// getter for balance
//	public void setBalance(double balance) {
//		this.balance = balance;
//	}
	
	public boolean getStatusOfAccount() {
		return statusOfAccount;
	}
	
	// only access for employees need to add  so that only employee can do that
	public void setStatusOfAccount(boolean statusOfAccount) {
		if (User.getType() == 2 || User.getType() == 3) {			
			this.statusOfAccount = statusOfAccount;
			System.out.println("The status of your account is " + this.statusOfAccount);
		} 
	}
	
	public void cancelAccount(boolean statusOfAccount) {
		if (User.getType() == 3) {			
			System.out.println("Your account has been deleted");
		} 
	}
	// admin can cancel account
	
	public double deposit(double amount) {
		System.out.println("You made a deposit.");
		// add to balance
		return this.balance + amount;
	}
	
	public double withdraw(double amount) {
		System.out.println("You made a withdraw");
		return this.balance - amount;
	}
	
	public double transfer(double amount, String accountName) {
		System.out.println("You made a transfer to " + accountName + ".");
		return this.balance - amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void approveAccount() {
		// this is basically where the constructor should go
		// i think
	}

}
