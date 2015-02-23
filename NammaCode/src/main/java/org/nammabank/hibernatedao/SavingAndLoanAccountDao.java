package org.nammabank.hibernatedao;

import java.util.List;

import org.nammabank.modelObjects.LoanAccountDetail;
import org.nammabank.modelObjects.SavingsAccountDetails;

public interface SavingAndLoanAccountDao {

// Savings account operations
	
	public SavingsAccountDetails getAccountDetail(String accountId);

	public void deleteAccount(SavingsAccountDetails account);

	public void updateAccountDetail(SavingsAccountDetails account);

	public List<SavingsAccountDetails> getAllAccounts();

	public void addNewAccount(SavingsAccountDetails account);
	
// Loan account operations 
	
	public LoanAccountDetail getLoanAccountDetail(String accountId);

	public void deleteLoanAccount(LoanAccountDetail account);

	public void updateLoanAccountDetail(LoanAccountDetail account);

	public List<LoanAccountDetail> getAllLoanAccounts();

	public void addNewLoanAccount(LoanAccountDetail account);
}
