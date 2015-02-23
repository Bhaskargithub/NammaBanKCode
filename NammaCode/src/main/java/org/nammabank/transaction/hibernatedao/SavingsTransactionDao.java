package org.nammabank.transaction.hibernatedao;

import java.util.List;

import org.nammabank.transaction.objects.SavingsTransactions;

public interface SavingsTransactionDao {

	public SavingsTransactions getUserSavingTrx(int userId, int yearComboId);

	public void addNewSavingTrxData(SavingsTransactions savingTx);

	public void updateSavingTx(SavingsTransactions savingTx);

	public void deleteSavedTx(SavingsTransactions savingTx);

	public List<SavingsTransactions> getAnnualSavingData(int userId, int year);

}
