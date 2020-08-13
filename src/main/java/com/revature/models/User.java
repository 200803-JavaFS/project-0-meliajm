package com.revature.models;

import java.io.Serializable;

public class User implements Serializable {
	// all getters and setters?

	
	private static final long serialVersionUID = 1L;
	
	private int userID;
	private String username;
	private String password;
	private int type; //1 is basic, 2 employee, 3 is admin
	// User has many Accounts, or can have more than one
	private String firstName;
	private String lastName;
	
	public User() {
		super();
	}
	
	public User(String username, String password, int type, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public User(int userID, String username, String password, int type, String firstName, String lastName) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		if (username.equals("")) {} 
		else {			
			this.username = username;
		}
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		if (type==2 || type==3) {			
			this.type = type;
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password.equals("")) {} 
		else {			
			this.password = password;
		}
	}
	
	

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
	
	
	
//	int userEnum, this will be 1 for basic
//	2 for employee
//	3 for admin
//	accountID
	
	// are you an employee
	// check to confirm user is an employee?
	// employee id?
	
	
	
	

}
