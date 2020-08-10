package com.revature.models;

public class Account {
	
	private double balance;
	private boolean statusOfAccount;
	private int id;
	// Account has a User
	
	public Account() {
		super();
		balance = 0.00;
		statusOfAccount = true;
		// set id for account too
	}
	
//	public Account() {
//		super();
//	}
	
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
	
	public double deposit(double amount) {
		if (amount <= 0) {
			System.out.println("You must deposit a positive value.");
			return this.balance;
		} else {
			// add to balance
			System.out.println("You made a deposit.");
			return this.balance + amount;
		}
	}
	
	public double withdraw(double amount) {
		if (amount <= 0) {
			System.out.println("You must withdraw a positive value.");
			return this.balance;
		} else if (this.balance - amount >= 0) {			
			System.out.println("You made a withdraw.");
			return this.balance - amount;
		} else {
			System.out.println("You cannot over-withdraw from your account.");			
			return this.balance;
		}
	}
	
	public double transfer(double amount, String accountName) {
		if (amount <= 0) {
			System.out.println("You can only transfer a positive amount.");
			return this.balance;
		} else if (this.balance - amount >= 0) {			
			System.out.println("You made a transfer to " + accountName + ".");
			return this.balance - amount;
		} else {
			System.out.println("You cannot transfer that amount based on the current balance of your account.");
			return this.balance;
		}
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
