package org.namma.dummy;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nammabank.utility.TransactionMonth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class FillMonthTable {

	
	@Autowired
	private  SessionFactory sessionFactory;
	
public void insertValues(){
		
		// = new String[12];
		 String months[] = {"January" , "February" , "March" , "April", "May","June", "July", "August", "September", "October","November", "December"};
		 Session ury = getSessionFactory().getCurrentSession();
		 TransactionMonth trxm = new TransactionMonth();
		int val = 0;
		 
		 for(int i=2005;i<2021;i++){
			 for(int j=0;j<months.length;j++){
				 String code = i + String.format("%02d", j+1);
				 val = 12*(i-2005)+j;
				 int combo = Integer.parseInt(code);
				 Query exc = ury.createSQLQuery("INSERT INTO transaction_month(trnx_id, active_month_yn, month, year, yr_mon_combo) VALUES (?,?,?,?,?)");
				 exc.setInteger(0, val);
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

public SessionFactory getSessionFactory() {
	return sessionFactory;
}

public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}
	
}
