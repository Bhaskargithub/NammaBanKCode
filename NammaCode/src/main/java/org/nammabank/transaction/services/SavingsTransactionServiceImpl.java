package org.nammabank.transaction.services;

import java.util.List;

import org.nammabank.transaction.hibernatedao.SavingsTransactionDao;
import org.nammabank.transaction.objects.SavingsTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SavingsTransactionServiceImpl implements SavingsTransactionService {

	@Autowired
	private SavingsTransactionDao savingsTransactionDao;
	
	
	@Override
	public SavingsTransactions getSavingTransactions(int userId, int yearComboId) {
		
		return getSavingsTransactionDao().getUserSavingTrx(userId,yearComboId);
	}

	@Override
	public List<SavingsTransactions> getSavingTrxList(int userId, int year) {
		
		return getSavingsTransactionDao().getAnnualSavingData(userId,year);
	}
	
	@Override
	public void addSavingTransactions(SavingsTransactions savingTx) {
		getSavingsTransactionDao().addNewSavingTrxData(savingTx);
		
	}

	@Override
	public void updateSavingTransactions(SavingsTransactions savingTx) {
		getSavingsTransactionDao().updateSavingTx(savingTx);
		
	}

	@Override
	public void deleteSavingTransactions(SavingsTransactions savingTx) {
		getSavingsTransactionDao().deleteSavedTx(savingTx);
		
	}

	public SavingsTransactionDao getSavingsTransactionDao() {
		return savingsTransactionDao;
	}

	public void setSavingsTransactionDao(SavingsTransactionDao savingsTransactionDao) {
		this.savingsTransactionDao = savingsTransactionDao;
	}

	

	

}
