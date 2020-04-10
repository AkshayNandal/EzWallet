package wallet.crud;

import java.sql.ResultSet;
import java.sql.SQLException;

import wallet.model.*;

public class AccountRowMapper implements 
org.springframework.jdbc.core.RowMapper<wallet.model.Account>{
	@Override
	public Account mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		wallet.model.Account account=new wallet.model.Account();
		account.setAccountID(resultSet.getString("AccountID"));
		account.setAccount_Name(resultSet.getString("Account_Name"));
		account.setAccount_Balance(resultSet.getDouble("Account_Balance"));
		account.setPin(resultSet.getString("Pin"));
		return account;
	}

}
