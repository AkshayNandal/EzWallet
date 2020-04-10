package wallet.crud;

import wallet.exceptions.*;
import wallet.model.Account;
public interface AccountDAO {
	public int createAccount(Account account)
	throws InsufficientFundsException;
	public java.util.List<wallet.model.Account> getAllAccounts();
	public wallet.model.Account getAccountByID(String AccountID) throws AccountNotFoundException, InsufficientFundsException;
	public double deposit(double Amount, String AccountID) throws AccountNotFoundException;
	public double withdraw(double Amount,String AccountID) throws AccountNotFoundException, InsufficientFundsException;
	public double fundTransfer(String AccountID, String AccountID2, double Amount) throws AccountNotFoundException, InsufficientFundsException;
	public int transferRecorder(String AccountID,String transactionType,String transactionID,double Account_Balance) throws AccountNotFoundException, PassbookNotFoundException;
	public String generatePin();
		
}
