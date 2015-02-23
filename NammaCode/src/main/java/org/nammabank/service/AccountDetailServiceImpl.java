package org.nammabank.service;

import java.util.List;

import org.nammabank.hibernatedao.BankAndGroupDetailDao;
import org.nammabank.hibernatedao.SavingAndLoanAccountDao;
import org.nammabank.modelObjects.LoanAccountDetail;
import org.nammabank.modelObjects.SavingsAccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountDetailServiceImpl implements AccountDetailService {

	@Autowired
	private SavingAndLoanAccountDao savingAndLoanAccountDao;
	
	
	@Override
	public SavingsAccountDetails getAccountDetail(String accountId) {
		return getSavingAndLoanAccountDao().getAccountDetail(accountId);
		
	}

	@Override
	public List<SavingsAccountDetails> getAllAccountList() {
		return getSavingAndLoanAccountDao().getAllAccounts();
		
	}
	
	@Override
	public void addAccountDetail(SavingsAccountDetails account) {
		System.out.println("inside savings dao impl");
		getSavingAndLoanAccountDao().addNewAccount(account);
		
	}

	@Override
	public void updateAccount(SavingsAccountDetails account) {
		getSavingAndLoanAccountDao().updateAccountDetail(account);
		
	}

	@Override
	public void deleteAccount(SavingsAccountDetails account) {
		getSavingAndLoanAccountDao().deleteAccount(account);
		
	}

	public SavingAndLoanAccountDao getSavingAndLoanAccountDao() {
		return savingAndLoanAccountDao;
	}

	public void setSavingAndLoanAccountDao(SavingAndLoanAccountDao savingAndLoanAccountDao) {
		this.savingAndLoanAccountDao = savingAndLoanAccountDao;
	}

	@Override
	public LoanAccountDetail getLoanAccountDetail(String accountId) {
		return getSavingAndLoanAccountDao().getLoanAccountDetail(accountId);
	}

	@Override
	public List<LoanAccountDetail> getAllLoanAccountList() {
		return getSavingAndLoanAccountDao().getAllLoanAccounts();
	}

	@Override
	public void addLoanAccountDetail(LoanAccountDetail account) {
		getSavingAndLoanAccountDao().addNewLoanAccount(account);
		
	}

	@Override
	public void updateLoanAccount(LoanAccountDetail account) {
		getSavingAndLoanAccountDao().updateLoanAccountDetail(account);
		
	}

	@Override
	public void deleteLoanAccount(LoanAccountDetail account) {
		getSavingAndLoanAccountDao().deleteLoanAccount(account);
		
	}
	

}
