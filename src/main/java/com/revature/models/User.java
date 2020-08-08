package com.revature.models;

public class User {
	
	
	private String username;
	private String password;
	private static int type; //1 is basic, 2 employee, 3 is admin
	// User has many Accounts, or can have more than one
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.setPassword(password);
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public static int getType() {
		return type;
	}

	public void setType(int type) {
		User.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
//	int userEnum, this will be 1 for basic
//	2 for employee
//	3 for admin
//	accountID
	
	// are you an employee
	// check to confirm user is an employee?
	// employee id?
	
	
	
	

}
