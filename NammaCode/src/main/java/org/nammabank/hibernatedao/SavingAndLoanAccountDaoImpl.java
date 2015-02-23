package org.nammabank.hibernatedao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nammabank.modelObjects.LoanAccountDetail;
import org.nammabank.modelObjects.SavingsAccountDetails;
import org.nammabank.modelObjects.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class SavingAndLoanAccountDaoImpl implements SavingAndLoanAccountDao {

	@Autowired
	private  SessionFactory sessionFactory;

	
	@Override
	public SavingsAccountDetails getAccountDetail(String accountId) {
	 return	(SavingsAccountDetails) getSessionFactory().getCurrentSession().get(SavingsAccountDetails.class, accountId);
		
	}

	@Override
	public void deleteAccount(SavingsAccountDetails account) {
		getSessionFactory().getCurrentSession().delete(account);
		
	}

	@Override
	public void updateAccountDetail(SavingsAccountDetails account) {
		getSessionFactory().getCurrentSession().update(account);
		
	}

	@Override
	public List<SavingsAccountDetails> getAllAccounts() {
		String hql = "select u from SavingsAccountDetails u";
		Session sess = getSessionFactory().getCurrentSession();
		List<SavingsAccountDetails> allUser = (List<SavingsAccountDetails>) sess.createQuery(hql).list();
		return allUser;
	
	}

	@Override
	public void addNewAccount(SavingsAccountDetails account) {
		getSessionFactory().getCurrentSession().save(account);
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	// Implementation for loan account updates
	
	@Override
	public LoanAccountDetail getLoanAccountDetail(String accountId) {
		return	(LoanAccountDetail) getSessionFactory().getCurrentSession().get(LoanAccountDetail.class, accountId);
		
	}

	@Override
	public void deleteLoanAccount(LoanAccountDetail account) {
		getSessionFactory().getCurrentSession().delete(account);
		
	}

	@Override
	public void updateLoanAccountDetail(LoanAccountDetail account) {
		getSessionFactory().getCurrentSession().update(account);
		
	}

	@Override
	public List<LoanAccountDetail> getAllLoanAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNewLoanAccount(LoanAccountDetail account) {
		getSessionFactory().getCurrentSession().save(account);
		
	}

}
