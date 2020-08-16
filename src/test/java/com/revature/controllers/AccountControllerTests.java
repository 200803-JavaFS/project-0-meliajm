package com.revature.controllers;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.controllers.AccountController;
import com.revature.daos.AccountDAO;
import com.revature.daos.UserDAO;

public class AccountControllerTests {
	
	public static AccountController ac;
	public static UserController uc;
//	public static AccountDAO aDao;
//	public static UserDAO uDao;
	public static Account a;
	public static User u;
	public static double depos;
	public static double z;
	public static double neg;
	public static double over;
	public static double withd;
	public static double tr;
//	public static double result;

	
	@BeforeClass
	public static void setAcc() {
		System.out.println("In BeforeClass");
	}
	
	@Before
	public void setFields() {
		System.out.println("In Before");
		// 
		ac = new AccountController();
		uc = new UserController();
		u = uc.findByID(99);
		a = new Account(200, 2, "CHECKING", u);
		depos = 500.00;
//		z = 0.00;
		withd = 100.00;
//		neg = -100.00;
//		over = 300.00;
		tr = 200.00;
				
	}
	
	@After
	public void clearResult() {
		System.out.println("In After");
//		result = 0.00;
	}
	
	@AfterClass
	public static void clearAcc() {
		System.out.println("In AfterClass");
//		ac.removeAccount(a.getAccountID());
//		uc.removeUser(u.getUserID());
		uc = null;
		ac = null;
	}
	
	@Test
	public void testDepositPositive() {
		System.out.println("Testing deposit positive");
		a = new Account(a.getBalance()+depos, a.getStatusOfAccount(), a.getAccountType(), u);
		ac.insertAccount(a);
		System.out.println("getbalance:"+a.getBalance());

		assertTrue(a.getBalance()==700.0);		
	}

//	@Test
//	public static void testDepositNotPositive() {
//		System.out.println("Testing deposit not positive");
//		a = new Account(a.getBalance()+depos, a.getStatusOfAccount(), a.getAccountType(), u);
//		ac.insertAccount(a);
//		assertTrue(a.getBalance()==700);	
//	}
	
	// test withdraw
	@Test
	public void testWithdraw() {
		System.out.println("Testing withdraw");
		a = new Account(a.getBalance()-withd, a.getStatusOfAccount(), a.getAccountType(), u);
		ac.insertAccount(a);
		System.out.println("getbalance:"+a.getBalance());
		assertTrue(a.getBalance()==100.0);
	}
	
//	@Test
//	public void testWithdrawNeg() {
//		System.out.println("Testing withdraw neg");
////		result = ac.withdraw(neg);
//		assertTrue(result == 100.00);		
//	}
	
//	@Test
//	public void testWithdrawOver() {
//		System.out.println("Testing withdraw over");
////		result = ac.withdraw(over);
//		assertTrue(result == 200.00);		
//	}
	
	// test transfer
	@Test
	public void testTransfer() {
		System.out.println("Testing transfer");
		a = new Account(a.getBalance()-tr, a.getStatusOfAccount(), a.getAccountType(), u);
		ac.insertAccount(a);
		System.out.println("getbalance:"+a.getBalance());
		assertTrue(a.getBalance()==0.0);
	}
	
//	@Test
//	public void testTransferNeg() {
//		System.out.println("Testing transfer");
////		result = ac.transfer(neg, accNam);
//		assertTrue(result == 200.00);
//	}
//	
//	@Test
//	public void testTransferOver() {
//		System.out.println("Testing transfer");
////		result = ac.transfer(over, accNam);
//		assertTrue(result == 200.00);
//	}

}
