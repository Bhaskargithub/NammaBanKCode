package org.namma.dummy;

import java.text.ParseException;

import org.nammabank.hibernatedao.UserInfoDao;
import org.nammabank.hibernatedao.UserInfoDaoImpl;
import org.nammabank.modelObjects.Address;
import org.nammabank.modelObjects.BankDetail;
import org.nammabank.modelObjects.GroupDetails;
import org.nammabank.modelObjects.SavingsAccountDetails;
import org.nammabank.modelObjects.UserInfo;
import org.nammabank.service.AccountDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class SessionMain {
	
	@Autowired
	private static UserInfoDao userInfoDao;
	
	
	
	@Autowired
	private static SessFctry sessFctry;

	public static void main(String[] args) throws ParseException {

		
		ApplicationContext dao = new ClassPathXmlApplicationContext("resources/hibernate/spring.xml");
		SessFctry sess = dao.getBean("sessFctry", SessFctry.class);
		System.out.println("insert values");
		//sess.insertValues();
		sess.insertSavingTrxValues();
		
		
		//--------------------------
		/*String accnum = "ACCNB450078";
		String bdc = accnum.substring(5);
				System.out.println(bdc+  1);
		int code = Integer.parseInt(bdc);
		int sum = code +1;
		//System.out.println(sum);
		String prefix = "ACCNB";
		long count = Long.parseLong(accnum.substring(5));
		String code = prefix + String.format("%06d", count + 1);
		System.out.println(code);*/
		/*SavingsAccountDetails account = new SavingsAccountDetails();
		
		account.setGroupId("India Group");
		ApplicationContext dao = new ClassPathXmlApplicationContext("resources/hibernate/spring.xml");
		SessFctry sess = dao.getBean("sessFctry", SessFctry.class);*/
		//SessFctry sess = new SessFctry();
		//sess.runQuery();
		
		//sess.saveAccount(account);
		
		/*BankDetail bdl = new BankDetail();
		//bdl.setBankId(6);
		bdl.setBankName("main flow");
		bdl.setCity("MANDYA");
		//sessFctry.saveBankDetail(bdl);
		
		GroupDetails group = new GroupDetails(),group2 = new GroupDetails();
		group.setGroupName("NammaSangha");
		group.setCity("MANDYA");
		
		group2.setGroupName("Sharada Sangha");
		group2.setCity("Mandya");
		
		bdl.getGroups().add(group);
		bdl.getGroups().add(group2);
		
		group.setRegisteredBank(bdl);
		group2.setRegisteredBank(bdl);
		
		ApplicationContext dao = new ClassPathXmlApplicationContext("resources/hibernate/spring.xml");
		SessFctry sess = dao.getBean("sessFctry", SessFctry.class);
		
		sess.saveBankDetail(bdl);*/
		
		/*UserInfo user = new UserInfo();
		//user.setUserId(1);
		user.setFirstName("nochmal");
		user.setLastName("IH");
		user.setPhoneNumber("+49176000000");

		Address addr = new Address();

		addr.setCity("Mandya");
		user.setAddress(addr);
*/
		
		/*BankDetail bdl = new BankDetail();
		//bdl.setBankId(6);
		bdl.setBankName("mess");
		bdl.setCity("MANDYA");
		sessFctry.saveBankDetail(bdl);*/
		//System.out.println(System.getProperty("java.class.path"));
		//ApplicationContext dao = new ClassPathXmlApplicationContext("resources/hibernate/spring.xml");
		//ApplicationContext dao = new ClassPathXmlApplicationContext("WEB-INF/spring/spring.xml");
		/*//UserInfoDaoImpl sess = (UserInfoDaoImpl)dao.getBean("userInfoDaoImpl", UserInfoDaoImpl.class);
		SessFctry sess = dao.getBean("sessFctry", SessFctry.class);
		System.out.println(sess.getUserInfo(22));
		//userInfoDao.saveUser(user);
*/		
		//sess.getCity();
		//System.out.println(sess.getCity());
	}

}
