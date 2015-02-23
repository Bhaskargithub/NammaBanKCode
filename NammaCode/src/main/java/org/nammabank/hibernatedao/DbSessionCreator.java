package org.nammabank.hibernatedao;

import java.sql.SQLException;
import java.util.Currency;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.nammabank.modelObjects.Address;
import org.nammabank.modelObjects.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DbSessionCreator {

	/*private static final Logger log = LoggerFactory
			.getLogger(DbSessionCreator.class);*/
	protected static Session session;

	// public static void main(String[] args) throws Exception{
	// TODO Auto-generated method stub
	/**
	 * here at get session
	 * 
	 * @return session
	 */
	public Session getSessionObj() {

		/*
		 * UserInfo user = new UserInfo(); // user.setUserId(1);
		 * user.setFirstName("aftermove"); user.setLastName("IH");
		 * user.setPhoneNumber("+49176000000");
		 * 
		 * Address addr = new Address();
		 * 
		 * addr.setCity("Mandya"); user.setAddress(addr);
		 */
		try {
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate/hibernate.cfg.xml");
			StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
			SessionFactory sessionFactory = configuration
					.buildSessionFactory(ssrb.build());
			session = sessionFactory.openSession();
			session.beginTransaction();
			return session;
		} catch (Exception e) {
			throw new RuntimeException();
		} /*finally {
			try {
				session.flush();
				session.close();
			} catch (Exception e) {
				String message = "Session not closed";
				log.error(message, e);
			}

		}*/

		/*
		 * session.beginTransaction(); session.save(user);
		 * session.getTransaction().commit(); session.close();
		 */

		/*
		 * session = sessionFactory.openSession(); user = (UserInfo)
		 * session.get(UserInfo.class, 2); System.out.println("User name is "+
		 * user.getLastName());
		 */

	}

}
