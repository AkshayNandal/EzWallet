package wallet.crud;

import wallet.exceptions.*;
import wallet.model.Account;
public interface AccountDAO {
	public int createAccount(Account account)
	throws InsufficientFundsException;
	public java.util.List<wallet.model.Account> getAllAccounts();
	public wallet.model.Account getAccountByID(String AccountID) throws AccountNotFoundException, InsufficientFundsException;
	public wallet.model.Account updateAccount(String AccountID, String Account_Name) throws AccountNotFoundException;
	public String generatePin();
		
}
