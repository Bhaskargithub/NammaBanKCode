package org.nammabank.transaction.balancesheets;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.nammabank.utility.TransactionMonth;

@Entity
public class GroupBalanceDetail {
	@Id
	private int grpBalId;
	
	private int groupId;
	
	
	private TransactionMonth trxMonth;
	
	private BigDecimal payments;
	
	private BigDecimal monthlyLending;
	
	private BigDecimal balance;
	
}
