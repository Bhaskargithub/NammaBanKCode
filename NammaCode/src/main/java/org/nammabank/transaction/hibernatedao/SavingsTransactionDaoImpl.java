package org.nammabank.transaction.hibernatedao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nammabank.transaction.objects.SavingsTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class SavingsTransactionDaoImpl implements SavingsTransactionDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public SavingsTransactions getUserSavingTrx(int userId, int yearComboId) throws HibernateException {
		
		Session session =  getSessionFactory().getCurrentSession();
		Query query = session.getNamedQuery("getTrxMonthGroupUser");
		query.setInteger(0, userId);
		query.setInteger(1, yearComboId);
		if(query.list().size() != 0){
		return (SavingsTransactions) query.list().get(0);
		}else return null;
		//return (SavingsTransactions) session.get(SavingsTransactions.class, idVal);
	}

	@Override
	public void addNewSavingTrxData(SavingsTransactions savingTx) {
		getSessionFactory().getCurrentSession().save(savingTx);
		
	}

	@Override
	public void updateSavingTx(SavingsTransactions savingTx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSavedTx(SavingsTransactions savingTx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SavingsTransactions> getAnnualSavingData(int userId, int year) {
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
