package wallet.aop;

import wallet.exceptions.*;

import org.springframework.beans.BeansException;

import wallet.crud.*;

public class AccountAop {
	private static org.springframework.context.ApplicationContext context;
	
	public void beforeCreateAccount() throws AccountNotCreatedException{
		context = new org.springframework.context.support.ClassPathXmlApplicationContext("applicationContext.xml");
		AccountDAO accountDao = (AccountDAO) context.getBean("accountDao");
		java.util.List<wallet.model.Account> accounts = accountDao.getAllAccounts();
		
		int maxID=0;
		for(wallet.model.Account account:accounts){
			int id=Integer.parseInt(account.getAccountID().substring(2));
			if(id>maxID){
				maxID=id;
		}
	}
		String newId=String.format("%014d", ++maxID);
		java.util.Random random= new java.util.Random();
		int firstNumber = (int)(random.nextDouble()*10);
		int secondNumber = (int)(random.nextDouble()*10);
		int thirdNumber = (int)(random.nextDouble()*10);
		int fourthNumber = (int)(random.nextDouble()*10);
		AccountDAOImpl.pin=""+firstNumber+secondNumber+thirdNumber+fourthNumber;
		AccountDAOImpl.newID=newId;
}
}
