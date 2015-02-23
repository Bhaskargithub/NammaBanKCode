package org.nammabank.hibernatedao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.nammabank.modelObjects.BankDetail;
import org.nammabank.modelObjects.GroupDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BankAndGroupDetailDaoImpl implements BankAndGroupDetailDao {

	@Autowired
	private  SessionFactory sessionFactory;
	
	

	@Override
	public BankDetail getBankDetail(int bankId)  throws HibernateException  {
		
		return (BankDetail) getSessionFactory().getCurrentSession().get(BankDetail.class, bankId);
	}

	/**
	 * Used persist for cascade save of child objects - the registered GROUPS are the cascaded objects
	 */
	@Override
	public void saveBankDetail(BankDetail bank)  throws HibernateException  {
		getSessionFactory().getCurrentSession().save(bank);
		
	}

	@Override
	public List<BankDetail> getAllBanks()  throws HibernateException  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBank(BankDetail bank)  throws HibernateException  {
		getSessionFactory().getCurrentSession().update(bank);
		
	}
	
	@Override
	public void deleteBank(BankDetail bank)  throws HibernateException  {
		getSessionFactory().getCurrentSession().delete(bank);

	}

	public SessionFactory getSessionFactory()  throws HibernateException  {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)  throws HibernateException  {
		this.sessionFactory = sessionFactory;
	}
	
	
	// Operation for group related dao objects

	@Override
	public GroupDetails getGroupDetail(int groupId)  throws HibernateException  {
		
		return (GroupDetails) getSessionFactory().getCurrentSession().get(GroupDetails.class, groupId);
	}

	@Override
	public void saveGroupDetail(GroupDetails group)  throws HibernateException  {
		getSessionFactory().getCurrentSession().save(group);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupDetails> getAllGroups()  throws HibernateException  {
		return (List<GroupDetails>) getSessionFactory().getCurrentSession().getNamedQuery("GetAllGroups").list();
		 
	}

	@Override
	public void updateGroup(GroupDetails group)  throws HibernateException  {
		getSessionFactory().getCurrentSession().update(group);
		
	}

	@Override
	public void deleteGroup(GroupDetails group)  throws HibernateException  {
		getSessionFactory().getCurrentSession().delete(group);
		
	}

	

}
