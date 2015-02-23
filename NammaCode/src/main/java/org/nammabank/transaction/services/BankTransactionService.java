package org.nammabank.transaction.services;

import java.util.List;

import org.nammabank.transaction.objects.BankTransactions;

public interface BankTransactionService {

	public void addBankTransactions(BankTransactions bankTrx);
	
	
	public void deleteBankTransactions(BankTransactions bankTrx);
	
	
	public void updateBankTransactions(BankTransactions bankTrx);
	
	
	public BankTransactions getBankTransactions(long bankTrxId);
	
	
	public List<BankTransactions> getBankTrxList();
	
	
}
