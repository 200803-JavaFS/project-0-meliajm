package com.revature.models;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AccountTests {
	
	public static Account a;
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
		System.out.println(a.getBalance());
		System.out.println(a.getId());
		// print out other getters
	}
	
	@Before
	public void setFields() {
		System.out.println("In Before");
		depos = 500.00;
		withd = 100.00;
		tr = 200.00;
		accNam = "Bank of Dog";
		a.setBalance(200.00);
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
		assertTrue(result == 700.00);		
	}
	
	// test withdraw
	@Test
	public void testWithdraw() {
		System.out.println("Testing withdraw");
		result = a.withdraw(withd);
		assertTrue(result == 100.00);		
	}
	
	// test transfer
	@Test
	public void testTransfer() {
		System.out.println("Testing transfer");
		result = a.transfer(tr, accNam);
		assertTrue(result == 0.00);
	}
	
	// test setStatusOfAccount - not sure if i need this
	

}
