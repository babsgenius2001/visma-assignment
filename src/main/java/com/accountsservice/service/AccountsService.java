package com.accountsservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.accountsservice.model.Accounts;
import com.accountsservice.model.AccountsDefault;

public interface AccountsService {

	List<Accounts> getAllBankAccountDetails();

	AccountsDefault fetchAllDefaultBankAccounts();

}
