package org.nammabank.hibernatedao;

import org.nammabank.modelObjects.Address;
import org.nammabank.modelObjects.UserInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"resources/hibernate/spring.xml");

		DbSessionCreator dao = ctx.getBean(DbSessionCreator.class);

		dao.getSessionObj();

		UserInfo user = new UserInfo();
		user.setUserId(1);
		user.setFirstName("dbsession");
		user.setLastName("IH");
		user.setPhoneNumber("+49176000000");

		Address addr = new Address();

		addr.setCity("Mandya");
		user.setAddress(addr);

		UserInfoDaoImpl impl = new UserInfoDaoImpl();
		impl.saveUser(user);

	}

}
