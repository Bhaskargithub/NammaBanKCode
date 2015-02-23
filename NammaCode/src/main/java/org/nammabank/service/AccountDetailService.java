package org.nammabank.service;

import java.util.List;

import org.nammabank.modelObjects.LoanAccountDetail;
import org.nammabank.modelObjects.SavingsAccountDetails;
import org.springframework.stereotype.Controller;

/**
 * 
 * @author Bhaskar, 
 * Service to add, delete, update individual accounts and related fields. 
 *
 */


public interface AccountDetailService {

	
	public SavingsAccountDetails getAccountDetail(String accountId);
	
	public List<SavingsAccountDetails> getAllAccountList();
	
	public void addAccountDetail(SavingsAccountDetails account);
	
	public void updateAccount(SavingsAccountDetails SavingsAccountDetails);
	
	public void deleteAccount(SavingsAccountDetails account);
	
	// Next follows for Loan account operations
	
	
	public LoanAccountDetail getLoanAccountDetail(String accountId);
	
	public List<LoanAccountDetail> getAllLoanAccountList();
	
	public void addLoanAccountDetail(LoanAccountDetail account);
	
	public void updateLoanAccount(LoanAccountDetail LoanAccountDetail);
	
	public void deleteLoanAccount(LoanAccountDetail account);

}
