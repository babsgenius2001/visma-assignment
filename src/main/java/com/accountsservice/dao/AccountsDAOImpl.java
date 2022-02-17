package com.accountsservice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import org.springframework.stereotype.Repository;

import com.accountsservice.model.Accounts;
import com.accountsservice.model.AccountsDefault;

@Repository
public class AccountsDAOImpl extends JdbcDaoSupport implements AccountsDAO {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public List<Accounts> getAllBankAccountDetails() {
		String sql = "SELECT * FROM bank_accounts_details";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

		List<Accounts> result = new ArrayList<Accounts>();

		for (Map<String, Object> row : rows) {
			Accounts bankAccountDetails = new Accounts();
			bankAccountDetails.setId((Long) row.get("id"));

			if (row.get("number") != null) {
				bankAccountDetails.setNumber((String) row.get("number"));
			} else {
				bankAccountDetails.setNumber("");
			}

			if (row.get("name") != null) {
				bankAccountDetails.setName((String) row.get("name"));
			} else {
				bankAccountDetails.setName("");
			}

			bankAccountDetails.setCreditcard((Boolean) row.get("creditcard"));
			bankAccountDetails.setSynthetic((Boolean) row.get("synthetic"));
			bankAccountDetails.setBalance((Double) row.get("balance"));
			result.add(bankAccountDetails);
		}

		return result;
	}

	@Override
	public AccountsDefault getAllBankAccountsDetailsDefault() {
		String sql = "SELECT * FROM bank_accounts_details where balance > 0 and synthetic = false";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql); // It will have only 2 records due to the
																				// criteria used
		List<Accounts> result = new ArrayList<Accounts>();

		for (Map<String, Object> row : rows) {

			Accounts bankAccountDetails = new Accounts();
			bankAccountDetails.setId((Long) row.get("id"));

			if (row.get("number") != null) {
				bankAccountDetails.setNumber((String) row.get("number"));
			} else {
				bankAccountDetails.setNumber("");
			}

			if (row.get("name") != null) {
				bankAccountDetails.setName((String) row.get("name"));
			} else {
				bankAccountDetails.setName("");
			}

			bankAccountDetails.setCreditcard((Boolean) row.get("creditcard"));
			bankAccountDetails.setSynthetic((Boolean) row.get("synthetic"));
			bankAccountDetails.setBalance((Double) row.get("balance"));
			result.add(bankAccountDetails);// 2 records will be pulled
		}
		
		AccountsDefault ad = new AccountsDefault();
		if (result.get(0).getBalance() > result.get(1).getBalance()
				|| result.get(0).getBalance() == 2 * (result.get(1).getBalance())) {
			ad.setId(result.get(0).getId());
		} else if (result.get(1).getBalance() > result.get(0).getBalance()
				|| result.get(1).getBalance() == 2 * (result.get(0).getBalance())) {
			ad.setId(result.get(1).getId());
		} else {
			ad.setId(null);
		}

		return ad;
	}
}
