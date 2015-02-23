package org.nammabank.utility;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.nammabank.modelObjects.LoanAccountDetail;
import org.nammabank.modelObjects.SavingsAccountDetails;
import org.nammabank.transaction.dboperations.AllQueriesDaoImpl;
import org.springframework.stereotype.Service;

/**
 * 
 * @author bhaskar
 * - Generate customized sequence for Savings and Loan account number 
 *
 */


@Service
public class AccountSeqGen implements IdentifierGenerator {

	public Serializable generate(SessionImplementor session, Object object)
			throws HibernateException {

		Query query = null;
		String prefix = null;
		long count = 0;
		String accnum;
		Session newSession = session.getFactory().getCurrentSession();

		if (object.getClass().equals(SavingsAccountDetails.class)) {

			query = newSession.getNamedQuery("SavingAcc.MaxVal");
			prefix = AllQueriesDaoImpl.SAVINGS_TABLE_PREFIX;
		} else if (object.getClass().equals(LoanAccountDetail.class)) {
			query = newSession.getNamedQuery("LoanAcc.MaxVal");
			prefix = AllQueriesDaoImpl.LOAN_TABLE_PREFIX;
		}
		if (query.list().get(0) != null) {
			accnum = (String) query.list().get(0);
			count = Long.parseLong(accnum.substring(5));
		}
		String code = prefix + String.format("%06d", count + 1);
		return code;

	}

}
