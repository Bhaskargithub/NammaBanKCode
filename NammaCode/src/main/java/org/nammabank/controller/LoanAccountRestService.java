package org.nammabank.controller;

import java.util.List;

import org.nammabank.modelObjects.LoanAccountDetail;
import org.nammabank.service.AccountDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author bhaskar Takes care of CRUD ops for Savings and Loan account
 */

@Controller
@RequestMapping(value = "/loanAccount")
public class LoanAccountRestService {

	@Autowired
	private AccountDetailService accountDetailService;

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public LoanAccountDetail getAccountDetail(
			@PathVariable("id") String accountId) {

		return getAccountDetailService().getLoanAccountDetail(accountId);

	}

	@RequestMapping(value = "allAccountDetail", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<LoanAccountDetail> getAllAccountList() {
		List<LoanAccountDetail> allUsers = getAccountDetailService()
				.getAllLoanAccountList();
		return allUsers;
	}

	@RequestMapping(value = "saveAccountDetail", method = RequestMethod.POST, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	public void saveNewAccount(@RequestBody LoanAccountDetail account) {
		getAccountDetailService().addLoanAccountDetail(account);
	}

	@RequestMapping(value = "updateAccountDetail", method = RequestMethod.PUT, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	public void updateUser(@RequestBody LoanAccountDetail account) {
		getAccountDetailService().updateLoanAccount(account);
	}

	@RequestMapping(value = "deleteAccountDetail", method = RequestMethod.DELETE, consumes = { "application/json" })
	@ResponseBody
	public void deleteAccountDetail(@RequestBody LoanAccountDetail account) {
		getAccountDetailService().deleteLoanAccount(account);
	}

	public AccountDetailService getAccountDetailService() {
		return accountDetailService;
	}

	public void setAccountDetailService(
			AccountDetailService accountDetailService) {
		this.accountDetailService = accountDetailService;
	}
}
