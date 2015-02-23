package org.nammabank.transaction.objects;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * 
 * @author bhaskar
 * - Different groups use different templates for operations
 * Ex: In case of loan repayment template
 * 	   GroupA - 22 month repayment period, @ Fixed interest
 *     GroupB - 11 month repayment period, @ cut interest
 * Ex: Also - in case of savings template
 *     GroupA - 500 Rs monthly saving
 *     GroupB - 1000 Rs monthly saving
 *     GroupC - 1500 Rs monthly saving
 */
@Entity
@Component
@NamedQuery(name="GetAllTemplate",query="from TemplateForms")
@JsonAutoDetect
@Table(name="TEMPLATE_FORMS")
public class TemplateForms {

	@Id
	@Column(name = "TEMPLATE_ID")
	private int templateId;
	
	@Column(name="TEMPLATE_NAME")
	private String templateName;
	
	/**
	 * --> saving type or loan type
	 */
	@Column(name="TEMPLATE_TYPE")
	private String templateType;
	
	// Recovery in months
	@Column(name="REPAYMENT_PERIOD")
	private int repaymentperiod;
	
	@Column(name="INTEREST_TYPE")
	private String interestType;
	
	@Column(name="MONTHLY_EMI")
	private BigDecimal monthlyEMI;

	public int getTemplateId() {
		return templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public int getRepaymentperiod() {
		return repaymentperiod;
	}

	public void setRepaymentperiod(int repaymentperiod) {
		this.repaymentperiod = repaymentperiod;
	}

	public String getInterestType() {
		return interestType;
	}

	public void setInterestType(String interestType) {
		this.interestType = interestType;
	}

	public BigDecimal getMonthlyEMI() {
		return monthlyEMI;
	}

	public void setMonthlyEMI(BigDecimal monthlyEMI) {
		this.monthlyEMI = monthlyEMI;
	}

	
	
	
	
}
