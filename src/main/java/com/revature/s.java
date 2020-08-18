//package com.revature;
//
//import java.util.*;
//
//import com.revature.models.Account;
//import com.revature.models.User;
//
//public class s {
//
//    public static void main(String[] args) {
//    	// put this in try, catch block
//    	
//    	int typeOfUser;
//    	String username = null;
//    	String password = null;
//    	int findOrCreateAccount;
//    	int checkingOrSavings;
//    	Account a = null;
//    	   	
//    	System.out.println("Welcome to Bank of Dog!");
////    	not sure if we have to do sign up too or just login
////    	let's start with just login, so user already is created
//
//    	Scanner scan = new Scanner(System.in);
//
//    	
//    	System.out.println("What type of user are you?");
//    	System.out.println("1 for basic user");
//    	System.out.println("2 for employee");
//    	System.out.println("3 for admin");
//    	System.out.println("4 for exit");
//    	typeOfUser = scan.nextInt();
//        
//        if (typeOfUser==1 || typeOfUser==2 || typeOfUser==3) {        	
//        	System.out.println("What is your username?");
//        	scan.nextLine();
//        	username = scan.nextLine();
//        	System.out.println("What is your password?");
////        	scan.nextLine();
//        	password = scan.nextLine();
//        } else if (typeOfUser==4) {
//        	System.out.println("Goodbye.");
////        	something else happens here
////        	i'd like to start back at the very beginning
//        } else {
//        	System.out.println("Not sure what you mean.");
//        }
//        
//        System.out.println("What would you like to do?");
//        System.out.println("1 for create account");
//    	System.out.println("2 for find existing account");
//    	System.out.println("3 for exit");
//    	findOrCreateAccount = scan.nextInt(); 
//    	
//    	if (findOrCreateAccount == 1) {
//    		System.out.println("Creating account...");
//    		System.out.println("What type of account are you creating?");
//    		System.out.println("1 for checking");
//    		System.out.println("2 for savings");
//    		checkingOrSavings = scan.nextInt();
//    			if (checkingOrSavings == 1) {    				
////    				a  = new Account("Checking");
//    			} else if (checkingOrSavings == 2) {
////    				a  = new Account("Savings");
//    			} else if (checkingOrSavings == 3) {
//    				System.out.println("Goodbye.");    				
//    			} else {
//    				//something here to restart loop
//    				// make each of these methods and nest them?
//    			}
//
//
//    		// account needs to be associated with a user
//    		// account must be approved by employee or admin
//    		// so initialize account, then later admin/employ can approve
//    		// by changing status of account
//    	} else if (findOrCreateAccount == 2) {
//    		System.out.println("Finding account...");
//    	} else if (findOrCreateAccount==3) {
//        	System.out.println("Goodbye.");
//    	}
//        
//        scan.close();
//        
////        User u = new User(username, password, typeOfUser);
//        
////        System.out.println(u);
////        System.out.println(u.getUsername());
////        System.out.println(u.getPassword());
////        System.out.println(u.getType());
////        
////        System.out.println("Account type: " + a.getType());
////        
//        System.out.println("Username: " + username);
//        System.out.println("Password: " + password);
//
//        System.out.println("Type of user: " + typeOfUser);
//        System.out.println("Find or create: " + findOrCreateAccount);
//        
//    }
//    
//    
//}
