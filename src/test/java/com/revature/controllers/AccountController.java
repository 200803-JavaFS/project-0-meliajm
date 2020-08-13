package com.revature.controllers;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.Account;
import com.revature.controllers.AccountController;

public class AccountController {

	public static Account a;
	public static AccountController ac;
	public static double depos;
	public static double z;
	public static double neg;
	public static double over;
	public static double withd;
	public static double tr;
	public static String accNam;
	public static double result;
	
	@BeforeClass
	public static void setAcc() {
		System.out.println("In BeforeClass");
		a = new Account();
		ac = new AccountController();
		System.out.println(a.getStatusOfAccount());
		System.out.println(a.getBalance());
		System.out.println(a.getId());
		// print out other getters
	}
	
	@Before
	public void setFields() {
		System.out.println("In Before");
		depos = 500.00;
		z = 0.00;
		withd = 100.00;
		neg = -100.00;
		over = 300.00;
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
		ac = null;
	}
	
	@Test
	public static void testDepositPositive() {
		System.out.println("Testing deposit positive");
		
		result = ac.deposit(depos);
		assertTrue(result == 700.00);		
	}

	@Test
	public static void testDepositNotPositive() {
		System.out.println("Testing deposit not positive");
		result = ac.deposit(z);
		assertTrue(result == 200.00);		
	}
	
	// test withdraw
	@Test
	public static void testWithdraw() {
		System.out.println("Testing withdraw");
		result = ac.withdraw(withd);
		assertTrue(result == 100.00);		
	}
	
	@Test
	public void testWithdrawNeg() {
		System.out.println("Testing withdraw neg");
		result = ac.withdraw(neg);
		assertTrue(result == 200.00);		
	}
	
	@Test
	public void testWithdrawOver() {
		System.out.println("Testing withdraw over");
		result = ac.withdraw(over);
		assertTrue(result == 200.00);		
	}
	
	// test transfer
	@Test
	public void testTransfer() {
		System.out.println("Testing transfer");
		result = ac.transfer(tr, accNam);
		assertTrue(result == 0.00);
	}
	
	@Test
	public void testTransferNeg() {
		System.out.println("Testing transfer");
		result = ac.transfer(neg, accNam);
		assertTrue(result == 200.00);
	}
	
	@Test
	public void testTransferOver() {
		System.out.println("Testing transfer");
		result = ac.transfer(over, accNam);
		assertTrue(result == 200.00);
	}

}
