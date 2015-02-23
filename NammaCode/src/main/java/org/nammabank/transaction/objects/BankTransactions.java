package org.nammabank.transaction.objects;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.nammabank.modelObjects.BankDetail;
import org.nammabank.modelObjects.GroupDetails;
import org.nammabank.modelObjects.UserInfo;
import org.nammabank.utility.TransactionMonth;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * 
 * @author bhaskar
 * Normal bank transaction per group. Deposit and recovery
 *
 */
@Entity
@Component
@JsonAutoDetect
@Table(name="BANK_TRANSACTIONS" )
public class BankTransactions {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRANSACTION_ID")
	private long tranxId;
	
	/*@ManyToOne
	@JoinColumn(name="BANK_ID")
	private BankDetail bank;*/
	
	@ManyToOne
	@JoinColumn(name="GROUP_ID")
	private GroupDetails groupId;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserInfo retriever; //Name taken 
	
	@ManyToOne
	@JoinColumn(name="LOAN_TAKER")
	private UserInfo loanGivenTo;
	
	@ManyToOne
	@JoinColumn(name="TRANSACTION_MONTH")
	private TransactionMonth trxMonth;
	
	
	@Column(name="TRANSACTION_TYPE")
	private String tranxType; //Deposit or retrieval at main distinction
	
	@Column(name="DESCRIPTION")
	private String description;
	
	
	private BigDecimal deposit;
	
	private BigDecimal retrieval;
	
	private BigDecimal netBalance;
	
	@Temporal(TemporalType.DATE)
	private Date tranxDate;

	public long getTranxId() {
		return tranxId;
	}

	public void setTranxId(long tranxId) {
		this.tranxId = tranxId;
	}

	public GroupDetails getGroupId() {
		return groupId;
	}

	public void setGroupId(GroupDetails groupId) {
		this.groupId = groupId;
	}

	public UserInfo getRetriever() {
		return retriever;
	}

	public void setRetriever(UserInfo retriever) {
		this.retriever = retriever;
	}

	public UserInfo getLoanGivenTo() {
		return loanGivenTo;
	}

	public void setLoanGivenTo(UserInfo loanGivenTo) {
		this.loanGivenTo = loanGivenTo;
	}

	public TransactionMonth getTrxMonth() {
		return trxMonth;
	}

	public void setTrxMonth(TransactionMonth trxMonth) {
		this.trxMonth = trxMonth;
	}

	public String getTranxType() {
		return tranxType;
	}

	public void setTranxType(String tranxType) {
		this.tranxType = tranxType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getDeposit() {
		return deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public BigDecimal getRetrieval() {
		return retrieval;
	}

	public void setRetrieval(BigDecimal retrieval) {
		this.retrieval = retrieval;
	}

	public BigDecimal getNetBalance() {
		return netBalance;
	}

	public void setNetBalance(BigDecimal netBalance) {
		this.netBalance = netBalance;
	}

	public Date getTranxDate() {
		return tranxDate;
	}

	public void setTranxDate(Date tranxDate) {
		this.tranxDate = tranxDate;
	}
	
}
