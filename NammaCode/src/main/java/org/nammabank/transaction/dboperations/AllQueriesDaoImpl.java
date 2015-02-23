package org.nammabank.transaction.dboperations;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.nammabank.modelObjects.BankDetail;
import org.nammabank.modelObjects.GroupDetails;
import org.nammabank.modelObjects.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class AllQueriesDaoImpl {

	
	public static String Savings_Account_Details = "SavingsAccountDetails";
	
	public static String ROW_COUNT = "SELECT COUNT(*) FROM ";
	
	public static String SAVINGS_TABLE_PREFIX = "ACCNB";
	
	public static String LOAN_TABLE_PREFIX = "LOANB";
	
	public static String BANK_TABLE_PREFIX = "NBANK";
	
	public static String GROUP_TABLE_PREFIX = "GROUP";
	
	public static String USER_TABLE_PREFIX = "NUSER";
	
	public static String  SAVINGS_ACC_MAXVAL =  "SELECT max(ACCOUNT_NUMBER) from  SAVINGS_ACCOUNT";
	
	/*String hql = "select * from UserInfo where userId='1'";
	Query abc = sess.createQuery(hql);
	UserInfo userInfo = (UserInfo) abc.uniqueResult();*/
	/*System.out.println(userInfo.getFirstName());
	return userInfo;*/
	
	@Autowired
	private  SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//Use trigger function to update as required

	// get list of groups for a bank
	
	// get all transaction on month x for group
	
	// get all transaction on month x for user in a group
	
	// Stored Proc -  generate monthly statement for each individual
	
	// Stored proc - generate stored proc for group


}

	
