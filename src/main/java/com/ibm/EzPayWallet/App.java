package com.ibm.EzPayWallet;

import wallet.exceptions.*;
import wallet.crud.*;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.BeansException;

import wallet.model.*;

public class App {
	static Scanner sc = new Scanner(System.in);
	static org.springframework.context.ApplicationContext context;
	static AccountDAO accountDao;
    public static void main( String[] args ) throws AccountNotFoundException, SQLException, InsufficientFundsException, BeansException{
    	context=new org.springframework.context.support.ClassPathXmlApplicationContext("applicationContext.xml");
    	accountDao=(AccountDAO) context.getBean("accountDao");
    	int choice=0;
    	while(true){
    		System.out.println("Welcome to EzPayWallet!");
    		System.out.println("1. Create Account");
    		System.out.println("2. Retrieve Account Details and Balance");
    		System.out.println("3. Deposit money");
    		System.out.println("4. Withdraw money");
    		System.out.println("5. Fund Transfer");
    		System.out.println("6. Recent Transactions");
    		System.out.println("Choice?");
    		choice=sc.nextInt();
    		sc.nextLine();
    		switch(choice){
    			case 1: createAccount(); break;
    			case 2: getAccountByID(); break;
    			case 3: deposit(); break;
    			case 4: withdraw(); break;
    			case 5: fundTransfer(); break;
    			case 6: recentTransactions(); break;
    			default: System.out.println("Invalid Choice");
    	}    		
   	}
}

	private static void withdraw() {
			System.out.println("Enter your AccountID:");
			String id=sc.nextLine();
			System.out.println("Enter the amount you want to withdraw");
			double amount=sc.nextDouble();
			try {
				double status=accountDao.withdraw(amount,id);
				System.out.println("Amout withdrawn! "+status);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	}
}

	private static void deposit(){
		System.out.println("Enter your AccountID: ");
		String id=sc.nextLine();
		System.out.println("Enter the amount you want to deposit");
		double amount=sc.nextDouble();
		try {
			double status=accountDao.deposit(amount,id);
			System.out.println("Amount credited! "+status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
}
	

	private static void recentTransactions() {
		// TODO Auto-generated method stub
		
	}
	private static void fundTransfer() {
		System.out.println("Enter your ID:");
		String id=sc.nextLine();
		System.out.println("Enter the ID you want to transfer to:");
		String id2=sc.nextLine();
		System.out.println("Enter the amount:");
		double amount=sc.nextDouble();
		try {
			double status1=accountDao.withdraw(amount,id);
			System.out.println("Transfer Successful! "+status1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			double status2=accountDao.deposit(amount,id2);
			System.out.println("Money Received! "+status2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void getAccountByID() throws InsufficientFundsException, AccountNotFoundException{
		System.out.println("Enter your Account ID: ");
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
		//sc.nextLine();
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
