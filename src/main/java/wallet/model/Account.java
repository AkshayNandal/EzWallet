package wallet.model;

public class Account {
	private String AccountID;
	private String Account_Name;
	private double Account_Balance;
	private String Pin;
	
	public Account(String accountID, String account_Name, double account_Balance, String pin) {
		this.AccountID = accountID;
		this.Account_Name = account_Name;
		this.Account_Balance = account_Balance;
		this.Pin = pin;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public String getAccountID() {
		return AccountID;
	}

	public void setAccountID(String accountID) {
		AccountID = accountID;
	}

	public String getAccount_Name() {
		return Account_Name;
	}

	public void setAccount_Name(String account_Name) {
		Account_Name = account_Name;
	}

	public double getAccount_Balance() {
		return Account_Balance;
	}

	public void setAccount_Balance(double account_Balance) {
		Account_Balance = account_Balance;
	}

	public String getPin() {
		return Pin;
	}

	public void setPin(String pin) {
		Pin = pin;
	}

	@Override
	public String toString() {
		return "Account [AccountID=" + AccountID + ", Account_Name=" + Account_Name + ", Account_Balance="
				+ Account_Balance + ", Pin=" + Pin + "]";
	}
	
}
