package com.accountsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accountsservice.model.Accounts;
import com.accountsservice.model.AccountsDefault;
import com.accountsservice.service.AccountsService;


@RestController
public class AccountsController {

	@Autowired
	AccountsService accountsService;

	@RequestMapping(value = "/bankaccounts", method = RequestMethod.GET)
	public List<Accounts> getAllBankAccountsDetails() {
		return accountsService.getAllBankAccountDetails();
	}
	
	@RequestMapping(value = "/bankaccounts/default", method = RequestMethod.GET)
	public AccountsDefault getBankAccountsDetailsDefault() {
		return accountsService.fetchAllDefaultBankAccounts();
	}
}
