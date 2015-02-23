package org.nammabank.utility;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@NamedQuery(name="GetAllTrxMonths",query="from TransactionMonth")
@Component
@Table(name = "TRANSACTION_MONTH")
public class TransactionMonth {
	
	@Id
	@Column(name = "TRNX_ID")
	private long trnxId;
	
	@Column(name = "YR_MON_COMBO")
	private int yrMonthCombo;
	
	@Column(name = "YEAR")
	private int year;
	
	@Column(name = "MONTH")
	private String month;
	
	@Column(name = "ACTIVE_MONTH_YN")
	public String activeMonthYN;
	
	public long getTrnxId() {
		return trnxId;
	}
	
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYrMonthCombo() {
		return yrMonthCombo;
	}
	public void setYrMonthCombo(int yrMonthCombo) {
		this.yrMonthCombo = yrMonthCombo;
	}
	public String getActiveMonthYN() {
		return activeMonthYN;
	}
	public void setActiveMonthYN(String activeMonthYN) {
		this.activeMonthYN = activeMonthYN;
	}
	public void setTrnxId(long trnxId) {
		this.trnxId = trnxId;
	}
	
}
