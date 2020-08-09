package com.revature;

import java.util.*;

public class s {

    public static void main(String[] args) {
    	
    	int typeOfUser;
    	String username = null;
    	String password = null;
    	int findOrCreateAccount;
    	   	
    	System.out.println("Welcome to Bank of Dog!");
//    	not sure if we have to do sign up too or just login
//    	let's start with just login, so user already is created

    	Scanner scan = new Scanner(System.in);

    	
    	System.out.println("What type of user are you?");
    	System.out.println("1 for basic user");
    	System.out.println("2 for employee");
    	System.out.println("3 for admin");
    	System.out.println("4 for exit");
    	typeOfUser = scan.nextInt();
        
        if (typeOfUser==1 || typeOfUser==2 || typeOfUser==3) {        	
        	System.out.println("What is your username?");
        	scan.nextLine();
        	username = scan.nextLine();
        	System.out.println("What is your password?");
//        	scan.nextLine();
        	password = scan.nextLine();
        } else if (typeOfUser==4) {
        	System.out.println("Goodbye.");
//        	something else happens here
//        	i'd like to start back at the very beginning
        }
        
        System.out.println("What would you like to do?");
        System.out.println("1 for create account");
    	System.out.println("2 for find existing account");
    	System.out.println("3 for exit");
    	findOrCreateAccount = scan.nextInt(); 
    	
    	if (findOrCreateAccount == 1) {
    		System.out.println("Creating account...");
    	} else if (findOrCreateAccount == 2) {
    		System.out.println("Finding account...");
    	} else if (findOrCreateAccount==3) {
        	System.out.println("Goodbye.");
    	}
        
        scan.close();
       
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        System.out.println("Type of user: " + typeOfUser);
        System.out.println("Find or create: " + findOrCreateAccount);
        
    }
    
    
}
