package com.accountsservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountsservice.dao.AccountsDAO;
import com.accountsservice.model.Accounts;
import com.accountsservice.model.AccountsDefault;
import com.accountsservice.service.AccountsService;

@Service
public class AccountsServiceImpl implements AccountsService {

	@Autowired
	AccountsDAO accountsDao;

	public List<Accounts> getAllBankAccountDetails() {
		List<Accounts> accountDetails = accountsDao.getAllBankAccountDetails();
		return accountDetails;
	}

	@Override
	public AccountsDefault fetchAllDefaultBankAccounts() {
		AccountsDefault accountDefaultDetails = accountsDao.getAllBankAccountsDetailsDefault();
		return accountDefaultDetails;
	}


}
