package org.nammabank.transaction.hibernatedao;

import java.util.List;

import org.nammabank.transaction.objects.BankTransactions;

public interface BankTransactionDao {

	void addBnkTrx(BankTransactions bankTrx);

	void deleteBnkTransaction(BankTransactions bankTrx);

	void updateBankTransaction(BankTransactions bankTrx);

	BankTransactions getBankTransaction(long bankTrxId);

	List<BankTransactions> getAllBankTrxList();

	
	
}
