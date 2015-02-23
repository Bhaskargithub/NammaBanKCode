package org.nammabank.modelObjects;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.nammabank.transaction.objects.TemplateForms;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * 
 * @author bhaskar
 *The key loanaccount id to maintain all following loan and
 *the loan re-payment transactions
 *Also mapped to Savings account for reference
 *A user of a group can have one savingsaccount and single loanaccount 
 */


@Entity
@Component
@NamedNativeQuery(name="LoanAcc.MaxVal" , query = "select max(LOANACC_NUMBER) from  LOAN_ACCOUNT")
@JsonAutoDetect
@Table(name="LOAN_ACCOUNT" )
public class LoanAccountDetail {// extends Account {


	
	@Id
	@GenericGenerator(name="accSeq_id", strategy="org.nammabank.utility.AccountSeqGen")
	@GeneratedValue(generator="accSeq_id")
	@Column(name = "LOANACC_NUMBER", unique = true)// length = 11)
	private String accountNumber;
	
	@Column(name = "ACCOUNT_TYPE")
	private String accountType;
	
	@ManyToOne
	private SavingsAccountDetails mainAccount;
	
	@ManyToOne
	@JoinColumn(name = "GROUP_ID")
	private GroupDetails groupId;

	@ManyToOne
	@JoinColumn(name="USER_ID")//,nullable = false)
	private UserInfo userId;
	
	@Column(name="ACTIVE_YN")//,nullable = false)
	private String activeYN;
	
	@ManyToOne
	@JoinColumn(name="CURRENT_TEMPLATE")
	private TemplateForms template;
	
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


/*	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}*/


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


	public SavingsAccountDetails getMainAccount() {
		return mainAccount;
	}


	public void setMainAccount(SavingsAccountDetails mainAccount) {
		this.mainAccount = mainAccount;
	}


	public GroupDetails getGroupId() {
		return groupId;
	}


	public void setGroupId(GroupDetails groupId) {
		this.groupId = groupId;
	}


	public UserInfo getUserId() {
		return userId;
	}


	public void setUserId(UserInfo userId) {
		this.userId = userId;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
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
	
}
