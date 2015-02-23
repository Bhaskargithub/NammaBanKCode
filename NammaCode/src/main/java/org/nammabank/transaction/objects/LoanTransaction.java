package org.nammabank.transaction.objects;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.nammabank.modelObjects.LoanAccountDetail;
import org.nammabank.utility.TransactionMonth;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * 
 * @author bhaskar
 *Loan taken is mapped to user loanaccountdetail to track
 *the user and maintain the heirarchy tree
 */
@Entity
@Component
@JsonAutoDetect
@Table(name="LOAN_TRANSACTION" )
public class LoanTransaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LOAN_ID")
	private long loanId;
	
	
	@ManyToOne
	private TemplateForms template;
	
	/**
	 * Loan is a strong entity and each transaction is a weak entity (value type)
	 * so all the transaction of repayment for a particular loan taken is embedded into it.
	 * Along with - it need index to support proper transaction - so collection 
	 */
	
	
	@ElementCollection
	@GenericGenerator(name="hilo-gen",strategy="hilo")
	@JoinTable(name="LOAN_RECOVERY",joinColumns=@JoinColumn(name="LOAN_ID"))
	@CollectionId(columns = { @Column(name="RECOVERY_ID") }, generator = "hilo-gen", type = @Type(type="long"))
	private Collection<LoanRecoveryTransactions> recover = new ArrayList<LoanRecoveryTransactions>();
	
	@Column(name="LOAN_COMPLETE_YN")
	private Boolean paymentCompleteYN;
	
	@ManyToOne
	@JoinColumn(name="LOAN_ACC_ID")
	private LoanAccountDetail loanAccId;
	
	@ManyToOne
	@JoinColumn(name="LOAN_TAKEN_MONTH")
	private TransactionMonth loanTakenMonth;
	
	@Column(name="LOAN_DATE")
	@Temporal(TemporalType.DATE)
	private Date loanDate;
	
	@Column(name="LOAN_AMOUNT")
	private BigDecimal loanAmount;
	
	@Column(name="RECOVERY_PERIOD")
	private int recoveryPeriod;

	public long getLoanId() {
		return loanId;
	}

	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}

	public TemplateForms getTemplate() {
		return template;
	}

	public void setTemplate(TemplateForms template) {
		this.template = template;
	}

	public Collection<LoanRecoveryTransactions> getRecover() {
		return recover;
	}

	public void setRecover(Collection<LoanRecoveryTransactions> recover) {
		this.recover = recover;
	}

	public Boolean getPaymentCompleteYN() {
		return paymentCompleteYN;
	}

	public void setPaymentCompleteYN(Boolean paymentCompleteYN) {
		this.paymentCompleteYN = paymentCompleteYN;
	}

	public LoanAccountDetail getLoanAccId() {
		return loanAccId;
	}

	public void setLoanAccId(LoanAccountDetail loanAccId) {
		this.loanAccId = loanAccId;
	}

	public TransactionMonth getLoanTakenMonth() {
		return loanTakenMonth;
	}

	public void setLoanTakenMonth(TransactionMonth loanTakenMonth) {
		this.loanTakenMonth = loanTakenMonth;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getRecoveryPeriod() {
		return recoveryPeriod;
	}

	public void setRecoveryPeriod(int recoveryPeriod) {
		this.recoveryPeriod = recoveryPeriod;
	}
	
}
