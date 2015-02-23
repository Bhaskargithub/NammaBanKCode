package org.namma.dummy;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nammabank.hibernatedao.UserInfoDao;
import org.nammabank.modelObjects.BankDetail;
import org.nammabank.modelObjects.SavingsAccountDetails;
import org.nammabank.modelObjects.UserInfo;
import org.nammabank.service.AccountDetailService;
import org.nammabank.service.BankDetailService;
import org.nammabank.service.UserServiceIntf;
import org.nammabank.transaction.objects.*;
import org.nammabank.transaction.dboperations.AllQueriesDaoImpl;
import org.nammabank.utility.TransactionMonth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SessFctry {

	@Autowired
	private  SessionFactory sessionFactory;

	/*@Autowired
	private UserInfoDao userInfoDao;*/
	
	@Autowired
	private AccountDetailService accountDetailService;
	
	@Autowired
	private BankDetailService bankDetailService;
	
	@Autowired
	private UserServiceIntf userIntf;
	
	/*public static void main(String[] args) {
		// public void abcd(){
		String city = getCity();
		System.out.println(city);
	}*/
	
public void insertSavingTrxValues() throws ParseException{
		
		// = new String[12];
		// String months[] = {"January" , "February" , "March" , "April", "May","June", "July", "August", "September", "October","November", "December"};
		 Session ury = getSessionFactory().getCurrentSession();
		 SavingsTransactions savTrxm = new SavingsTransactions();
		long val = 0;
		BigDecimal monthEMi = BigDecimal.valueOf(1000.00);
		BigDecimal balanceEMI =  BigDecimal.valueOf(0.00);
		String trxMonth = "80";
		Date myDate = new Date();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(myDate));
		//Date dateTo = new SimpleDateFormat("yyyy-MM-dd").format(myDate)
		String dateStr = "2011-09-15";
		Date dateTo = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		savTrxm.setAmountPaid(monthEMi);
		savTrxm.setBalanceEMI(balanceEMI);
		savTrxm.setFixedEMI(monthEMi);
		savTrxm.setPaymentDate(dateTo);
		savTrxm.setYearMonthCombo(201109);
		savTrxm.setTotalSaving(monthEMi);
		savTrxm.setLtrnxMonth((TransactionMonth)ury.get(TransactionMonth.class, Long.parseLong(trxMonth)));
		savTrxm.setSavingTranx((SavingsAccountDetails) ury.get(SavingsAccountDetails.class, "ACCNB000002"));
		ury.save(savTrxm);
		
		
		/* for(int i=2005;i<2021;i++){
			 for(int j=0;j<months.length;j++){
				 String code = i + String.format("%02d", j+1);
				 val = (long)12*(i-2005)+j;
				 int combo = Integer.parseInt(code);
				 Query exc = ury.createSQLQuery("INSERT INTO transaction_month(trnx_id, active_month_yn, month, year, yr_mon_combo) VALUES (?,?,?,?,?)");
				 exc.setLong(0, val);
				 exc.setString(1, "NO");
				 exc.setString(2, months[j]);
				 exc.setInteger(3, i);
				 exc.setInteger(4, combo);
				 exc.executeUpdate();
			 }
		 }*/
		 
}

	
	public void insertValues(){
		
		// = new String[12];
		 String months[] = {"January" , "February" , "March" , "April", "May","June", "July", "August", "September", "October","November", "December"};
		 Session ury = getSessionFactory().getCurrentSession();
		 TransactionMonth trxm = new TransactionMonth();
		long val = 0;
		 
		 for(int i=2005;i<2021;i++){
			 for(int j=0;j<months.length;j++){
				 String code = i + String.format("%02d", j+1);
				 val = (long)12*(i-2005)+j;
				 int combo = Integer.parseInt(code);
				 Query exc = ury.createSQLQuery("INSERT INTO transaction_month(trnx_id, active_month_yn, month, year, yr_mon_combo) VALUES (?,?,?,?,?)");
				 exc.setLong(0, val);
				 exc.setString(1, "NO");
				 exc.setString(2, months[j]);
				 exc.setInteger(3, i);
				 exc.setInteger(4, combo);
				 exc.executeUpdate();
				 
				 
				 
				 /*trxm.setActiveMonthYN("NO");
				 trxm.setTrnxId(val);
				 System.out.println("execs"+j);
				 trxm.setMonth(months[j]);
				 trxm.setYear(i);
				 trxm.setYrMonthCombo(Integer.parseInt(code));
				 ury.save(trxm);*/
				// System.out.println("Expected output " + code + "\t" +months[j]+"\t" +i);
			 }
				 
		 }
		 
	}
	
	public void saveAccount(SavingsAccountDetails account){
		accountDetailService.addAccountDetail(account);
	}
	
	public  String getCity() {
		String hql = "select firstName from UserInfo";
		Session ury = getSessionFactory().openSession();
		//Session ury = getSessionFactory().getCurrentSession();
		
		Query abc = ury.createQuery(hql);
		String city = (String) abc.uniqueResult();
		System.out.println(city);
		return city;
		
	}
	
	public void saveUserInfo(UserInfo user){
		userIntf.saveUser(user);
	}
	
	public String getUserInfo(int user){
     return	userIntf.getUserInfo(user).getFirstName();

	}
	/*
	public void runQuery(){
		AllQueriesDaoImpl abc = new AllQueriesDaoImpl();
		System.out.println(abc.getAccountCount());
	}
	*/
	public void saveBankDetail(BankDetail dataB){
	/*	Session sess = getSessionFactory().openSession();
		sess.beginTransaction();
		
		sess.getTransaction().commit();*/
		//Session sess = getSessionFactory().getCurrentSession();
		//sess.save(dataB);
		getBankDetailService().addBankDetail(dataB);
		
		System.out.println("saved here now");
		/*Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(dataB);
		System.out.println("saved here now");
		session.getTransaction().commit(); 
		session.flush();
		session.close();*/
		
		
		
		
	}
	
	public void forLogging(){
		System.out.println("inside logger");
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public BankDetailService getBankDetailService() {
		return bankDetailService;
	}

	public void setBankDetailService(BankDetailService bankDetailService) {
		this.bankDetailService = bankDetailService;
	}

}
