package org.nammabank.controller;

import java.util.List;

import org.nammabank.modelObjects.Account;
import org.nammabank.modelObjects.SavingsAccountDetails;
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
 * @author bhaskar
 *Takes care of CRUD ops for Savings and Loan account 
 */

@Controller
@RequestMapping(value="/savingAccount")
public class AccountRestService {

	

	@Autowired
	private AccountDetailService accountDetailService;
	
	
	@RequestMapping(value="get/{id}", method = RequestMethod.GET, produces={"application/json"} )
	@ResponseBody
	public SavingsAccountDetails getAccountDetail(@PathVariable("id") String accountId){
		System.out.println("inside rest get"+ accountId);
		SavingsAccountDetails account = getAccountDetailService().getAccountDetail(accountId);
		System.out.println(account.getAccountType());
		return account;
	}
	
	@RequestMapping(value="allAccountDetail", method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public List<SavingsAccountDetails> getAllAccountList(){
		List<SavingsAccountDetails> allUsers = getAccountDetailService().getAllAccountList();
		return allUsers;
	}
	
	
	@RequestMapping(value="saveAccountDetail", method = RequestMethod.POST, produces={"application/json"},consumes = {"application/json"})
	@ResponseBody
	public void saveNewAccount(@RequestBody SavingsAccountDetails account){
		getAccountDetailService().addAccountDetail(account);
	}
	
	@RequestMapping(value="updateAccountDetail", method = RequestMethod.PUT, produces={"application/json"},consumes = {"application/json"})
	@ResponseBody
	public void updateUser(@RequestBody SavingsAccountDetails account){
		getAccountDetailService().updateAccount(account);
	}
	
	@RequestMapping(value="deleteAccountDetail", method = RequestMethod.DELETE, consumes={"application/json"})
	@ResponseBody
	public void deleteAccountDetail(@RequestBody SavingsAccountDetails account){
		getAccountDetailService().deleteAccount(account);
		}
	
	
	public AccountDetailService getAccountDetailService() {
		return accountDetailService;
	}

	public void setAccountDetailService(AccountDetailService accountDetailService) {
		this.accountDetailService = accountDetailService;
	}
}
