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
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.nammabank.modelObjects.SavingsAccountDetails;
import org.nammabank.utility.TransactionMonth;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


@Entity
@Component
@NamedNativeQuery(name="getTrxMonthGroupUser" , 
query = "SELECT saving_transaction.* FROM saving_transaction,  savings_account where  saving_transaction.saving_acc_id = savings_account.account_number"
		+ " and savings_account.user_id = ?  and savings_account.group_id= 1  and saving_transaction.year_month= ? ", resultClass=SavingsTransactions.class)
@JsonAutoDetect
@Table(name="SAVING_TRANSACTION" )
public class SavingsTransactions {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SAVING_TRNX_ID")
	private long savingTxId;
	
	@ManyToOne
	@JoinColumn(name="SAVING_ACC_ID")
	private SavingsAccountDetails savingTranx;
	
	@ManyToOne
	@JoinColumn(name="TRANSACTION_MONTH")
	private TransactionMonth ltrnxMonth;
	
	//Check it - add the month and year combo field
	/*@ManyToOne
	@JoinColumn(name="YEAR_MONTH")
	private int yearMonthCombo;*/

	@Column(name="YEAR_MONTH")
	private int yearMonthCombo;
	
	
	@Column(name="FIXED_EMI")
	private BigDecimal fixedEMI;
	
	@Column(name="AMOUNT_PAID")
	private BigDecimal amountPaid;
	
	@Column(name="TOTAL_SAVING")
	private BigDecimal totalSaving;
	
	@Column(name="BALANCE_EMI")
	private BigDecimal balanceEMI;
	
	@ManyToOne
	@JoinColumn(name="TEMPLATE_ID")
	private TemplateForms template;
	
	
	
	
	@Column(name="PAYMENT_DATE")
	@Temporal(TemporalType.DATE)
	private Date paymentDate;




	public long getSavingTxId() {
		return savingTxId;
	}




	public void setSavingTxId(long savingTxId) {
		this.savingTxId = savingTxId;
	}




	public SavingsAccountDetails getSavingTranx() {
		return savingTranx;
	}




	public void setSavingTranx(SavingsAccountDetails savingTranx) {
		this.savingTranx = savingTranx;
	}




	public TransactionMonth getLtrnxMonth() {
		return ltrnxMonth;
	}




	public void setLtrnxMonth(TransactionMonth ltrnxMonth) {
		this.ltrnxMonth = ltrnxMonth;
	}




	public BigDecimal getFixedEMI() {
		return this.template.getMonthlyEMI();
	}




	public void setFixedEMI(BigDecimal fixedEMI) {
		this.fixedEMI = fixedEMI;
	}




	public BigDecimal getAmountPaid() {
		return amountPaid;
	}




	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}




	public BigDecimal getTotalSaving() {
		return totalSaving;
	}




	public void setTotalSaving(BigDecimal totalSaving) {
		this.totalSaving = totalSaving;
	}




	public BigDecimal getBalanceEMI() {
		return balanceEMI;
	}




	public void setBalanceEMI(BigDecimal balanceEMI) {
		this.balanceEMI = balanceEMI;
	}




	public TemplateForms getTemplate() {
		return template;
	}




	public void setTemplate(TemplateForms template) {
		this.template = template;
	}




	public Date getPaymentDate() {
		return paymentDate;
	}




	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}




	public int getYearMonthCombo() {
		return yearMonthCombo;
	}




	public void setYearMonthCombo(int yearMonthCombo) {
		this.yearMonthCombo = yearMonthCombo;
	}




	/*public int getYearMonthCombo() {
		return this.ltrnxMonth.getYrMonthCombo();
	}

	public void setYearMonthCombo(int yearMonthCombo) {
		this.ltrnxMonth.setYrMonthCombo(yearMonthCombo);
	}*/
	
}
