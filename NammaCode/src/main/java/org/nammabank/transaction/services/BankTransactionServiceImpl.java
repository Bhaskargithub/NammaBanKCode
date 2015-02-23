package org.nammabank.transaction.services;

import java.util.List;

import org.nammabank.transaction.hibernatedao.BankTransactionDao;
import org.nammabank.transaction.objects.BankTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {

	@Autowired
	private BankTransactionDao bankTransactionDao;
	
	@Override
	public void addBankTransactions(BankTransactions bankTrx) {
		getBankTransactionDao().addBnkTrx(bankTrx);
		
	}

	@Override
	public void deleteBankTransactions(BankTransactions bankTrx) {
		getBankTransactionDao().deleteBnkTransaction(bankTrx);
		
	}

	@Override
	public void updateBankTransactions(BankTransactions bankTrx) {
		getBankTransactionDao().updateBankTransaction(bankTrx);
		
	}

	@Override
	public BankTransactions getBankTransactions(long bankTrxId) {
		return getBankTransactionDao().getBankTransaction(bankTrxId);
		}

	@Override
	public List<BankTransactions> getBankTrxList() {
		
		return getBankTransactionDao().getAllBankTrxList();
	}

	public BankTransactionDao getBankTransactionDao() {
		return bankTransactionDao;
	}

	public void setBankTransactionDao(BankTransactionDao bankTransactionDao) {
		this.bankTransactionDao = bankTransactionDao;
	}

}
