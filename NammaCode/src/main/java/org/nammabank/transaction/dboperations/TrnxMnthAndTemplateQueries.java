package org.nammabank.transaction.dboperations;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.nammabank.transaction.objects.TemplateForms;
import org.nammabank.utility.TransactionMonth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class TrnxMnthAndTemplateQueries {

	@Autowired
	private  SessionFactory sessionFactory;
	
	public TemplateForms getTemplateDetail(int templId) throws HibernateException{
		return (TemplateForms) getSessionFactory().getCurrentSession().get(TemplateForms.class, templId);
		
	}

	@SuppressWarnings("unchecked")
	public List<TemplateForms> getAllTemplates() throws HibernateException{
		
		return (List<TemplateForms>) getSessionFactory().getCurrentSession().getNamedQuery("GetAllTemplate").list();
	}

	public List<TransactionMonth> getAllTrnxMonth() throws HibernateException{
		return (List<TransactionMonth>) getSessionFactory().getCurrentSession().getNamedQuery("GetAllTrxMonths").list();
	}

	public TransactionMonth getTrnxMonthDetail(long trxMonth) throws HibernateException{
		return (TransactionMonth) getSessionFactory().getCurrentSession().get(TransactionMonth.class, trxMonth);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
