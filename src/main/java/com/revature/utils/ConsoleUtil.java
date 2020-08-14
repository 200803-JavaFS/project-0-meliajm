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
		
		System.out.println("Do you want to signup (s) or login (l)?");
		String signupOrLogin = scan.nextLine();
		signupOrLoginSwitch(signupOrLogin);
		
		System.out.println();

		System.out.println("What would you like to do?");
		System.out.println("ALL to see all users");
		System.out.println("ONE to see one user");
		System.out.println("D to make a deposit");
		System.out.println("W to make a withdraw");
		System.out.println("T to make a transfer");




		System.out.println("EXIT to exit app");


		String answer = scan.nextLine();
		answerSwitch(answer);
	}

	private void signupOrLoginSwitch(String signupOrLogin) {
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
		System.out.println("What is your username?");
		String username = scan.nextLine();
		System.out.println("What is your password");
		String password = scan.nextLine();
		System.out.println("What is your first name");
		String firstName = scan.nextLine();
		System.out.println("What is your last name");
		String lastName = scan.nextLine();
		System.out.println("What is your user type? Basic (B), Employee (E), Admin (A)");
		String type = scan.nextLine();
		System.out.println("Do you have an account? Yes? No?");
//		String password = scan.nextLine();
		Account a = null;
		if (scan.nextLine().toLowerCase().equals("yes")) {
			a = findAccount();
		}
		User u = new User(username, password, type, firstName, lastName, a);
		if (uc.insertUser(u)) {
			System.out.println("You were added to the database");
			beginApp();
		} else {
			System.out.println("Please try again");
			beginApp();
		}
				
	}

	private Account findAccount() {
		System.out.println("Do you have an account already in the database? Yes? No?");
		String res = scan.nextLine();
		Account a = null;
		if (res.toLowerCase().equals("no")) {
			a = makeAccount();
		} else {
			uc.
		}
		return null;
	}

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
