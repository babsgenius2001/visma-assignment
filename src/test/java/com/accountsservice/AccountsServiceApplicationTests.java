
package com.accountsservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

import com.accountsservice.model.Accounts;
import com.accountsservice.model.AccountsDefault;
import com.accountsservice.service.AccountsService;

@SpringBootTest
@AutoConfigureMockMvc
class AccountsServiceApplicationTests {

	@MockBean
	private AccountsService accountsService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void should_get_all_bank_accounts_details() throws Exception {

		List<Accounts> bankAccountDetailsList = new ArrayList<Accounts>();
		Accounts s1 = new Accounts();
		s1.setId(Long.valueOf(1));
		s1.setNumber("1357756");
		s1.setName("Personal account");
		s1.setCreditcard(false);
		s1.setSynthetic(false);
		s1.setBalance(1202.14);

		Accounts s2 = new Accounts();
		s2.setId(Long.valueOf(2));
		s2.setNumber("2446987");
		s2.setName("Business account");
		s2.setCreditcard(false);
		s2.setSynthetic(false);
		s2.setBalance(34057.00);

		Accounts s3 = new Accounts();
		s3.setId(Long.valueOf(3));
		s3.setNumber("9981644");
		s3.setName("Credit card");
		s3.setCreditcard(true);
		s3.setSynthetic(false);
		s3.setBalance(-10057.00);

		Accounts s4 = new Accounts();
		s3.setId(Long.valueOf(4));
		s3.setNumber("");
		s3.setName("Expense claims");
		s3.setCreditcard(false);
		s3.setSynthetic(true);
		s3.setBalance(0.00);

		bankAccountDetailsList.add(s1);
		bankAccountDetailsList.add(s2);
		bankAccountDetailsList.add(s3);
		bankAccountDetailsList.add(s4);

		when(accountsService.getAllBankAccountDetails()).thenReturn(bankAccountDetailsList);

		mockMvc.perform(get("/bankaccounts")).andExpect(status().isOk()).andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.[?(@.number == 1357756 && @.name == \"Personal account\")]").exists())
				.andExpect(jsonPath("$.[?(@.number == 2446987 && @.name == \"Business account\")]").exists());
	}

	@Test
	public void should_get_default_bank_accounts() throws Exception {

		AccountsDefault acctDefaultList = new AccountsDefault();
		acctDefaultList.setId(Long.valueOf(2));

		when(accountsService.fetchAllDefaultBankAccounts()).thenReturn(acctDefaultList);

		mockMvc.perform(get("/bankaccounts/default")).andExpect(status().isOk()).andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.id").value(2));

	}
}
