package com.ibm.EzPayWallet;

import wallet.exceptions.*;
import wallet.crud.*;

import java.sql.SQLException;
import java.util.Scanner;
import wallet.model.*;

public class App {
	static Scanner sc = new Scanner(System.in);
	static org.springframework.context.ApplicationContext context;
	static AccountDAO accountDao;
    public static void main( String[] args ) throws AccountNotFoundException, SQLException, InsufficientFundsException{
    	context=new org.springframework.context.support.ClassPathXmlApplicationContext("applicationContext.xml");
    	accountDao=(AccountDAO) context.getBean("accountDao");
    	int choice=0;
    	while(true){
    		System.out.println("1. Create Account");
    		System.out.println("2. Retrieve Account Details and Balance");
    		System.out.println("3. Fund Transfer");
    		System.out.println("4. Recent Transactions");
    		System.out.println("5. Deposit");
    		System.out.println("Choice?");
    		choice=sc.nextInt();
    		switch(choice){
    			case 1: createAccount(); break;
    			case 2: getAccountByID(); break;
    			case 3: fundTransfer(); break;
    			case 4: recentTransactions(); break;
    			case 5: updateAccount(); break;
    			default: System.out.println("Invalid Choice");
    		}
    		
    	}
    	
    	
    }
	private static void updateAccount() {
		// TODO Auto-generated method stub
		
	}
	private static void recentTransactions() {
		// TODO Auto-generated method stub
		
	}
	private static void fundTransfer() {
		// TODO Auto-generated method stub
		
	}
	private static void getAccountByID() throws InsufficientFundsException, AccountNotFoundException{
		System.out.println("Enter your Account ID: ");
		sc.nextLine();
		String id=sc.nextLine();
		try{
			System.out.println(accountDao.getAccountByID(id)+"\n");
		}catch(org.springframework.dao.EmptyResultDataAccessException emrd){
			System.err.println("Account Not Found");
		}
//		try {
//			if(accountDao.getAccountByID(id).getAccount_Balance()<1000){	
//			}
//		} catch (InsufficientFundsException ife) {
//			System.err.println("Your account Balance is running low");
//		}
//		
	}
	private static void createAccount() throws SQLException, InsufficientFundsException {
		System.out.println("Account Name?");
		sc.nextLine();
		String name=sc.nextLine();
		System.out.println("Account Balance?");
		double balance=sc.nextDouble();
		
		Account account = new Account();
		account.setAccount_Name(name);
		account.setAccount_Balance(balance);
		int status=accountDao.createAccount(account);
		System.out.println("Status of the account "+status);
	}
}
