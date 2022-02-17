package com.accountsservice.dao;

import java.util.List;

import com.accountsservice.model.Accounts;
import com.accountsservice.model.AccountsDefault;

public interface AccountsDAO {
	List<Accounts> getAllBankAccountDetails();

	AccountsDefault getAllBankAccountsDetailsDefault();

}
