package org.nammabank.transaction.services;

import java.util.List;

import org.nammabank.transaction.objects.SavingsTransactions;

public interface SavingsTransactionService {

	

	void addSavingTransactions(SavingsTransactions savingTx);

	void updateSavingTransactions(SavingsTransactions savingTx);

	void deleteSavingTransactions(SavingsTransactions savingTx);

	SavingsTransactions getSavingTransactions(int userId, int yearComboId);

	List<SavingsTransactions> getSavingTrxList(int userId, int year);

	
}
