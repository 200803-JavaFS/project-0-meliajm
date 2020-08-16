questions:
which methods should be static in models?
how are associations made in Java?
how to delete a User or Account in Java?
how does a user login?
do we need to unit test our setters and getters?



to do:
[] check update for user
[] try, catch block for invalid inputs in menu like strings when it should be int
[?] connect scanner to Account
[?] associate User and Account
[] service layers for Accounts and Users
[] logging with log4j

[x] connect scanner to User
[x] test other conditions for Account included in if else
[x]add validation to accounts and users
[x]*over-withdraw
[x]*no negative numbers for amounts to be deposited, transferred, withdraw
[x]*no empty Strings for username or password, min char length of password


build menu (user interface)

build service layer
	-login
	-logout
	-models
		-User
			-methods (login, logout)
			-fields
		-Account
			-methods (deposit, withdraw, transfer, etc)
	--testing of User

	--testing of Account
	
user experience flow:
 1. welcome
 2. user type
 3. login for type 1
	 1. find or create account
	 2. get balance, transfer, withdraw, deposit
	 3. switch accounts
	 4. exit
	 
 4. login for type 2
 	1. employee can view all accounts
 	2. exit
 5. login for type 3
 	1. approve/deny accounts
 	2. withdraw, deposit, transfer from all accounts
 	3. cancel account
 	4. exit
 
 
ways to break
 1. null or empty fields 
 2. cannot over-withdraw
 3. cannot add negative numbers
 
 //
//	public static Account a;
//	public static double depos;
//	public static double z;
//	public static double neg;
//	public static double over;
//	public static double withd;
//	public static double tr;
//	public static String accNam;
//	public static double result;
 
 package com.revature;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.controllers.AccountController;
import com.revature.daos.AccountDAO;
import com.revature.models.Account;
import com.revature.utils.ConsoleUtil;

public class Driver {
	
	private static AccountDAO dao = new AccountDAO();
	
	ConsoleUtil cons = new ConsoleUtil();
	
	private void run() {			
		try {			
			cons.beginApp();
		} catch (InputMismatchException e) {
//			e.printStackTrace();
			System.out.println("you caught an exception");
			run();
		}
	
	public static void main(String[] args) {
//		run();
		cons.beginApp();
		
		
	}
//		List<Account> list = dao.findAll();
//		
//		for (Account a: list) {
//			System.out.println(a);
//		}
//		
//		Account a = new Account(0.00, "Savings")
	}
	
//	private static final Logger log = LogManager.getLogger(Driver.class);
//	
//	private static AccountController ac = new AccountController();
//
//	public static void main(String[] args) {
//		log.info("The application has started");
//		try {
//			recur();
//		} catch(Error e) {
//			Log.error("Oh no we encountered an error");
//		}
//		Account a = ac.findAccountById(1);
//		log.info("we have found acount: "+a);
//		log.info("the end of app");
//	}
//	public Driver() {		                                   
//	}
	
//	public static void recur() {
//		recur();
//	}
	

}
 
 
 
 // pass in arguments instead of having nested switches or if-else statements
 
 
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