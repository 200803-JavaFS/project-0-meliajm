package com.revature.models;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AccountTests {
	
	public static Account a;
	public static double bal;
	public static double depos;
	public static double withd;
	public static double tr;
	public static String accNam;
	public static double result;
	
	@BeforeClass
	public static void setAcc() {
		System.out.println("In BeforeClass");
		a = new Account();
		System.out.println(a.getStatusOfAccount());
		// print out other getters
	}
	
	@Before
	public void setFields() {
		System.out.println("In Before");
		bal = 0.00;
		depos = 500;
		withd = 100;
		tr = 200;
		accNam = "Bank of Dog";
	}
	
	@After
	public void clearResult() {
		System.out.println("In After");
		result = 0.00;
	}
	
	@AfterClass
	public static void clearAcc() {
		System.out.println("In AfterClass");
		a = null;
	}
	
	@Test
	public void testDeposit() {
		System.out.println("Testing deposit");
		result = a.deposit(depos);
		assertTrue(result == 500);		
	}
	

}
