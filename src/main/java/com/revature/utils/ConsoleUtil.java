package com.revature.utils;

import java.util.List;
import java.util.Scanner;

import com.revature.controllers.AccountController;
import com.revature.controllers.UserController;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.daos.UserDAO;
import com.revature.daos.AccountDAO;
//add try catch

public class ConsoleUtil {
	
	private static final Scanner scan = new Scanner(System.in);
	private AccountController ac = new AccountController();
	private UserController uc = new UserController();
	private UserDAO ud = new UserDAO();
	private AccountDAO ad = new AccountDAO();

	public void beginApp() {
		// admin employee basic user have different flows
		System.out.println("Welcome to the Bank of Dog");
		
		System.out.println("Do you want to signup (s), login (l), or exit(e)?");
		String signupOrLogin = scan.nextLine();
		signupOrLoginSwitch(signupOrLogin);
		
//		System.out.println();
//
//		System.out.println("What would you like to do?");
//		System.out.println("ALL to see all users");
//		System.out.println("ONE to see one user");
//		System.out.println("D to make a deposit");
//		System.out.println("W to make a withdraw");
//		System.out.println("T to make a transfer");
//
//
//
//
//		System.out.println("EXIT to exit app");
//
//
//		String answer = scan.nextLine();
//		answerSwitch(answer);
	}

	private void signupOrLoginSwitch(String signupOrLogin) {
		signupOrLogin = signupOrLogin.toLowerCase();
		switch(signupOrLogin) {
		case "s":
			signupUser();
			break;
		case "l":
			loginUser();
			break;
		case "e":
			System.out.println("Goodbye.");
			break;
		default:
			System.out.println("You have entered an incorrect value. Try again.");
			beginApp();
			break;

		}
		
	}

	private void signupUser() {
		// add validations for empty strings, etc.
		System.out.println("Please enter a username you'd like to use.");
		String username = scan.nextLine();
		System.out.println("Please enter a password.");
		String pass = scan.nextLine();
		System.out.println("What kind of user are you? Basic (b), employee (e), admin(a)");
		String userType = scan.nextLine();
		System.out.println("What is your first name?");
		String firstName = scan.nextLine();
		System.out.println("What is your last name?");
		String lastName = scan.nextLine();
		userType = userType.toLowerCase();
		User u = null;
		switch (userType) {
			case "b":
				u = new User(username, pass, 1, firstName, lastName);
				uc.insertUser(u);
				break;
			case "e":
				u = new User(username, pass, 2, firstName, lastName);
				uc.insertUser(u);
				break;
			case "a":
				u = new User(username, pass, 3, firstName, lastName);
				uc.insertUser(u);
				break;
			default:
				System.out.println("You have entered an incorrect value. Try again.");
				beginApp();
				break;
		}
//		uc.insertUser(u);
	}

	private void loginUser() {
		System.out.println("What is your user id?");
		int id = scan.nextInt();
		System.out.println("What is your password?");
		String pass = scan.nextLine();
		User us = uc.findByID(id);
		if (us!=null) {			
			if (us.getPassword().equals(pass)) {
				System.out.println("You are logged in.");
				System.out.println("user: "+us);
				System.out.println("user type: "+us.getType());
				System.out.println("user id: "+us.getUserID());
//				loginEachUserType();
				switch(us.getType()) {
					case 1:
						menuBasic();
						break;
					case 2:
						menuEmploy();
						break;
					case 3:
						menuAdmin();
						break;
					default:
						System.out.println("System error.");
						beginApp();
						break;
				}
			} else {
				System.out.println("Your password does not match.");
				beginApp();
			}
		} else {
			System.out.println("No user found with that username.");
			beginApp();
		}
	}
	
	
	
	
//	private void loginEachUserType() {
//		switch(us.getType()) {
//			case 1:
//				loginBasic();
//				break;
//			case 2:
//				loginEmploy();
//				break;
//			case 3:
//				loginAdmin();
//				break;
//			default:
//				System.out.println("System error.");
//				beginApp();
//				break;
//		}
//		
//	}

	private void menuAdmin() {
		// TODO Auto-generated method stub
		
	}

	private void menuEmploy() {
		// TODO Auto-generated method stub
		
	}

	private void menuBasic() {
		// TODO Auto-generated method stub
		
	}

	private void answerSwitch(String answer) {
		answer = answer.toLowerCase();
		switch (answer) {
			case "all":
				getAllUsers();
				break;
			case "exit":
				System.out.println("Goodbye.");
				break;
			case "one":
				getOneUser();
				break;
			case "add":
				addUser();
				break;
			default:
				System.out.println("You have entered an incorrect value. Try again.");
				beginApp();
				break;
		}
	}
	
	private void addUser() {
//		System.out.println("What is your username?");
//		String username = scan.nextLine();
//		System.out.println("What is your password");
//		String password = scan.nextLine();
//		System.out.println("What is your first name");
//		String firstName = scan.nextLine();
//		System.out.println("What is your last name");
//		String lastName = scan.nextLine();
//		System.out.println("What is your user type? Basic (B), Employee (E), Admin (A)");
//		String type = scan.nextLine();
//		System.out.println("Do you have an account? Yes? No?");
////		String password = scan.nextLine();
//		Account a = null;
//		if (scan.nextLine().toLowerCase().equals("yes")) {
//			a = findAccount();
//		}
//		User u = new User(username, password, type, firstName, lastName, a);
//		if (uc.insertUser(u)) {
//			System.out.println("You were added to the database");
//			beginApp();
//		} else {
//			System.out.println("Please try again");
//			beginApp();
//		}
				
	}

//	private Account findAccount() {
//		System.out.println("Do you have an account already in the database? Yes? No?");
//		String res = scan.nextLine();
//		Account a = null;
//		if (res.toLowerCase().equals("no")) {
//			a = makeAccount();
//		} else {
//			uc.
//		}
//		return null;
//	}

	private Account makeAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	private void getOneUser() {
		System.out.println("What is the id of the user you would like to see?");
		int i = scan.nextInt();
		scan.nextLine();
		User u = uc.findByID(i);
		System.out.println("Your user is: "+u);
		beginApp();
	}

	private void getAllUsers() {
		List<User> list = uc.findAll();
		System.out.println("Here are all users in the database");
		for (User u:list) {
			System.out.println(u);
		}
		beginApp();
	}
	
	

}
