package org.nammabank.transaction.objects;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.nammabank.utility.TransactionMonth;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


//@Entity
//@Component
@JsonAutoDetect
@Embeddable
//@Table(name="RECOVERY_TRANSACTIONS" )
public class LoanRecoveryTransactions {

	/*@Id
	@Column(name="LOAN_REC_PKID")
	private long loanPKId;*/
	
	@ManyToOne
	@JoinColumn(name="TRANSACTION_MONTH")
	private TransactionMonth trxMonth;
	
	@Column(name="PAID_YN")
	private String paidYN;
	
	@Column(name="EMI_PAID")
	private BigDecimal payment;
	
	@Column(name="TOTAL_EMI_PAID")
	private BigDecimal totalPaid;
	
	@Column(name="BALANCE_EMI_AMOUNT")
	private BigDecimal balancePay;

	public TransactionMonth getTrxMonth() {
		return trxMonth;
	}

	public void setTrxMonth(TransactionMonth trxMonth) {
		this.trxMonth = trxMonth;
	}

	public String getPaidYN() {
		return paidYN;
	}

	public void setPaidYN(String paidYN) {
		this.paidYN = paidYN;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	public BigDecimal getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(BigDecimal totalPaid) {
		this.totalPaid = totalPaid;
	}

	public BigDecimal getBalancePay() {
		return balancePay;
	}

	public void setBalancePay(BigDecimal balancePay) {
		this.balancePay = balancePay;
	}
	
}
