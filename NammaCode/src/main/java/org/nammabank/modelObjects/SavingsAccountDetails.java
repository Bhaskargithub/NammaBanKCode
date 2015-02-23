package org.nammabank.modelObjects;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.nammabank.transaction.dboperations.AllQueriesDaoImpl;
import org.nammabank.transaction.objects.TemplateForms;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * 
 * @author bhaskar
 *One savings account per user per group
 */

@Entity
@Component
@NamedNativeQuery(name="SavingAcc.MaxVal" , query = "select max(ACCOUNT_NUMBER) from  SAVINGS_ACCOUNT")
@JsonAutoDetect
@Table(name="SAVINGS_ACCOUNT" )
public class SavingsAccountDetails {// extends Account { 
		
	/**
	 * Loan account or savings account
	 */
	@Id
	@GenericGenerator(name="accSeq_id", strategy="org.nammabank.utility.AccountSeqGen")
	@GeneratedValue(generator="accSeq_id")
	@Column(name = "ACCOUNT_NUMBER", unique = true)// length = 11)
	private String accountNumber;
	
	@Column(name = "ACCOUNT_TYPE")
	private String accountType;
	
	@ManyToOne
	@JoinColumn(name="CURRENT_TEMPLATE")
	private TemplateForms template;
	
	@ManyToOne
	@JoinColumn(name="GROUP_ID")
	private GroupDetails groupId;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserInfo user; //Name taken 
	
	
	@Column(name="ACTIVE_YN")//,nullable = false)
	private String activeYN;
	
	@Column(name="START_DATE")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name="END_DATE", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date endDate;


	public String getAccountType() {
		return "SAVING";
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public GroupDetails getGroupId() {
		return groupId;
	}


	public void setGroupId(GroupDetails groupId) {
		this.groupId = groupId;
	}


	public UserInfo getUser() {
		return user;
	}


	public void setUser(UserInfo user) {
		this.user = user;
	}


	public void setActiveYN(String activeYN) {
		this.activeYN = activeYN;
	}


	public TemplateForms getTemplate() {
		return template;
	}


	public void setTemplate(TemplateForms template) {
		this.template = template;
	}


	public String getActiveYN() {
		return activeYN;
	}

/*	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}*/

	
}
