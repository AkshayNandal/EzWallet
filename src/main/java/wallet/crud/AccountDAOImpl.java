package wallet.crud;

import java.util.List;

import java.sql.*;

import org.springframework.jdbc.core.JdbcTemplate;

import wallet.exceptions.AccountNotFoundException;
import wallet.exceptions.InsufficientFundsException;
import wallet.model.Account;

public class AccountDAOImpl implements AccountDAO{

	private JdbcTemplate jdbcTemplate;  
	public static String pin;
	public static String newID;
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	
	@Override
	public int createAccount(Account account) throws InsufficientFundsException {
		String sql="INSERT INTO Account VALUES(?,?,?,?)";
		return jdbcTemplate.update(sql, (java.sql.PreparedStatement prepareStatement)-> {
			prepareStatement.setString(1, newID);
			prepareStatement.setString(2, account.getAccount_Name());
			prepareStatement.setDouble(3, account.getAccount_Balance());
			prepareStatement.setString(4, pin);
		});
	}
	

	@Override
	public List<Account> getAllAccounts() {
		String sql="SELECT * from Account";
		java.util.List<wallet.model.Account> accounts= jdbcTemplate.query(sql, new org.springframework.jdbc.core.RowMapper<wallet.model.Account>(){
			@Override
			public wallet.model.Account mapRow(java.sql.ResultSet resultSet, int rowNumber) throws java.sql.SQLException{
				wallet.model.Account account = new wallet.model.Account();
				account.setAccountID(resultSet.getString("AccountID"));
				account.setAccount_Name(resultSet.getString("Account_Name"));
				account.setAccount_Balance(resultSet.getDouble("Account_Balance"));
				account.setPin(resultSet.getString("Pin"));
				return account;
			}	
		});
		
		return accounts;
	}

	@Override
	public Account getAccountByID(String AccountID){
			String sql="SELECT * FROM Account Where AccountID=?";
			return jdbcTemplate.queryForObject(sql, new Object[] {AccountID},
					new org.springframework.jdbc.core.RowMapper<wallet.model.Account>(){

						@Override
						public Account mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
							wallet.model.Account account = new wallet.model.Account();
							account.setAccountID(resultSet.getString("AccountID"));
							account.setAccount_Name(resultSet.getString("Account_Name"));
							account.setAccount_Balance(resultSet.getDouble("Account_Balance"));
							account.setPin(resultSet.getString("Pin"));
							return account;
						}	
	});
}

	@Override
	public Account updateAccount(String AccountID, String Account_Name) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generatePin() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
