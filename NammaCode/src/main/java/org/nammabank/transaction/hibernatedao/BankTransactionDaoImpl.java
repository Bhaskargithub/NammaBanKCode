package org.nammabank.transaction.hibernatedao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.nammabank.transaction.objects.BankTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class BankTransactionDaoImpl implements BankTransactionDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void addBnkTrx(BankTransactions bankTrx) {
		getSessionFactory().getCurrentSession().save(bankTrx);
		
	}

	@Override
	public void deleteBnkTransaction(BankTransactions bankTrx) {
		getSessionFactory().getCurrentSession().delete(bankTrx);
		
	}

	@Override
	public void updateBankTransaction(BankTransactions bankTrx) {
		getSessionFactory().getCurrentSession().update(bankTrx);
		
	}

	@Override
	public BankTransactions getBankTransaction(long bankTrxId) {
		return (BankTransactions) getSessionFactory().getCurrentSession().get(BankTransactions.class,bankTrxId);
		
	}

	@Override
	public List<BankTransactions> getAllBankTrxList() {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
}
