package com.revature.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.controllers.AccountController;
import com.revature.controllers.UserController;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.daos.UserDAO;
import com.revature.daos.AccountDAO;
//add try catch
// pass in arguments instead of having nested switches or if-else statements

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
		System.out.println("What kind of user are you? Basic (b), Employee (e), Admin (a)");
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
				menuBasic(u);
				break;
			case "e":
				u = new User(username, pass, 2, firstName, lastName);
				uc.insertUser(u);
				menuBasic(u);
				break;
			case "a":
				u = new User(username, pass, 3, firstName, lastName);
				uc.insertUser(u);
				menuBasic(u);
				break;
			default:
				System.out.println("You have entered an incorrect value. Try again.");
				beginApp();
				break;
		}
	}

	private void loginUser() {
		System.out.println("What is your user id?");
		int id = scan.nextInt();
		scan.nextLine();
		System.out.println("What is your password?");
		String pass = scan.nextLine();
		User us = uc.findByID(id);
		System.out.println("id: "+ id);
		System.out.println("pass: "+ pass);
		System.out.println("user password: "+ us.getPassword().equals(pass));
		if (us!=null) {			
			if (us.getPassword().equals(pass)) {
				System.out.println("You are logged in.");
				System.out.println("user: "+us);
				System.out.println("user type: "+us.getType());
				System.out.println("user id: "+us.getUserID());
				switch(us.getType()) {
					case 1:
						menuBasic(us);
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
	
	private void menuBasic(User us) {
		System.out.println("What do you want to do? Open account (o), View accounts (v)");
		String ans = scan.nextLine();
		ans = ans.toLowerCase();
		switch(ans) {
		case "o":
			openAccount(us);
			break;
		case "v":
			viewAllUserAccounts(us);
			break;
		default:
			System.out.println("System error.");
			beginApp();
			break;
		}
	}
	
	private void viewAllUserAccounts(User us) {
//		test driver again
		System.out.println("You are viewing all of your accounts.");
		List<Account> list = uc.findUserAccounts(us);
		for(Account a:list) {
			System.out.println(a);
		}		
		updateUserAccount(us);
	}

	private void openAccount(User us) {
		System.out.println("You are opening an account.");
		System.out.println("Do you want to open a CHECKINGS (c) or SAVINGS (s)?");
		String accountType = scan.nextLine();
		accountType = accountType.toLowerCase();
		Account a = null;
		
		switch(accountType) {
		case "c":
			a = new Account(0.00, 1, "CHECKING", us);
			ac.insertAccount(a);
			viewAllUserAccounts(us);
			break;
		case "s":
			a = new Account(0.00, 1, "SAVINGS", us);
			ac.insertAccount(a);
			viewAllUserAccounts(us);
			break;
		default:
			System.out.println("System error.");
			beginApp();
			break;
		}		
	}

	

	private void updateUserAccount(User us) {
		System.out.println("Which of your accounts would you like to access? Please enter the account id.");
		int id = scan.nextInt();
		scan.nextLine();
		Account uAcc = ac.findByID(id);
		if (uAcc.getStatusOfAccount()==2) {			
			System.out.println("You are updating your account balance");
			System.out.println("Do you want make a WITHDRAW (w), TRANSFER (t), or DEPOSIT (d), or Exit (e)?");
			String resp = scan.nextLine();
			resp = resp.toLowerCase();
			System.out.println("What is the amount you want to " + resp + "?");
			double amount = scan.nextDouble();
			scan.nextLine();
			switch(resp) {
			case "w":
				uAcc = new Account(uAcc.getAccountID(), uAcc.getBalance() - amount, uAcc.getStatusOfAccount(), uAcc.getAccountType(), us);
				ac.updateAccount(uAcc);
				viewAllUserAccounts(us);
				break;
			case "t":
				System.out.println("What is the account id you want to transfer to?");
				int accountIDToTranfersTo = scan.nextInt();
				scan.nextLine();
				Account accountT = ac.findByID(accountIDToTranfersTo);
				System.out.println("accountToTransferTo"+ accountT.getStatusOfAccount());
				System.out.println("accountToTransferTo"+ accountT);
				if (accountT.getStatusOfAccount()==2 && accountT != null) {
					
					uAcc = new Account(uAcc.getAccountID(), uAcc.getBalance() - amount, uAcc.getStatusOfAccount(), uAcc.getAccountType(), us);
					ac.updateAccount(uAcc);
					accountT = new Account(accountT.getAccountID(), accountT.getBalance() + amount, accountT.getStatusOfAccount(), accountT.getAccountType(), accountT.getUser());
					ac.updateAccount(accountT);
					viewAllUserAccounts(us);
				} else {
					System.out.println("That's not an account available account");
					viewAllUserAccounts(us);
				}
				break;
			case "d":
				uAcc = new Account(uAcc.getAccountID(), uAcc.getBalance() + amount, uAcc.getStatusOfAccount(), uAcc.getAccountType(), us);
				ac.updateAccount(uAcc);
				viewAllUserAccounts(us);
				break;
			case "e":
				System.out.println("Goodbye " + us.getFirstName());
				break;
			default:
				System.out.println("System error.");
				beginApp();
				break;
			}
		} else {
			System.out.println("You cannot access this account because the status is not open");
			beginApp();
		}
	}
	
	private void menuEmploy() {
		System.out.println("Welcome, employee. You are able to view account and user information.");
		System.out.println("Here are all of the account information.");
		List<Account> list = ac.findAll();
		for(Account a:list) {
			System.out.println(a);
		}
		System.out.println("Please enter the account id of the account you would like to view.");
		int id = scan.nextInt();
		scan.nextLine();
		Account a = ac.findByID(id);
		System.out.println("Do you want to change the status of this account? Yes (y), No (n).");
		String ans = scan.nextLine();
		ans = ans.toLowerCase();
		
		switch(ans) {
		case "y":
			System.out.println("What do you want to change the status to be? Pending (p), Open (o).");
			String resp = scan.nextLine();
			resp = resp.toLowerCase();
			switch(resp) {
			case "p":
				System.out.println("The account status will be pending.");
				Account acc = new Account(a.getAccountID(), a.getBalance(), 1, a.getAccountType(), a.getUser());
				ac.updateAccount(acc);
				employLogoutQ();
				break;
			case "o":
				System.out.println("The account status will be open.");
				Account acco = new Account(a.getAccountID(), a.getBalance(), 2, a.getAccountType(), a.getUser());
				ac.updateAccount(acco);
				employLogoutQ();
				break;
			default:
				System.out.println("System error.");
				beginApp();
				break;
			}
			break;
		case "n":
			System.out.println("Goodbye, employee.");
			break;
		default:
			System.out.println("System error.");
			beginApp();
			break;
		}	
	}
	
	private void employLogoutQ() {
		System.out.println("Do you want to look another account? Yes (y), No (n).");
		String rep = scan.nextLine();
		rep = rep.toLowerCase();
		switch(rep) {
		case "y":
			menuEmploy();
			break;
		case "n":
			System.out.println("Goodbye, employee.");
			break;
		default:
			System.out.println("System error.");
			beginApp();
			break;
		}
	}

	private void menuAdmin() {
		// TODO Auto-generated method stub
		
	}

	

	


	
	

}
