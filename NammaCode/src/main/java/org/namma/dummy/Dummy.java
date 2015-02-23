package org.namma.dummy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.nammabank.modelObjects.BankDetail;
import org.nammabank.modelObjects.GroupDetails;

public class Dummy {

	public static void main(String[] args) {
	
		BankDetail bdl = new BankDetail();
		//bdl.setBankId(6);
		bdl.setBankName("with group");
		bdl.setCity("MANDYA");
		//sessFctry.saveBankDetail(bdl);
		
		GroupDetails group = new GroupDetails(),group2 = new GroupDetails();
		group.setGroupName("NammaSangha");
		group.setCity("MANDYA");
		
		group2.setGroupName("Sharada Sangha");
		group2.setCity("Mandya");
		
		/*bdl.getGroups().add(group);
		bdl.getGroups().add(group2);*/
		
	/*	group.setRegisteredBank(bdl);
		group2.setRegisteredBank(bdl);*/
		
		Configuration configuration = new Configuration();
		configuration.configure("resources/hibernate/spring.xml");
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(bdl);
		System.out.println("saved here now");
		session.getTransaction().commit(); 
		session.flush();
		session.close();
	}

}
