package org.nammabank.transaction.services;

import java.util.List;

import org.nammabank.transaction.objects.TemplateForms;
import org.nammabank.utility.TransactionMonth;

/**
 * 
 * @author bhaskar
 * - This handles service for transaction month table and template table
 */

public interface TrnxMnthAndTemplateService {

	TemplateForms getTemplateDetails(int accountId);

	List<TemplateForms> getTempList();

	List<TransactionMonth> getTrnxMonthList();

	TransactionMonth getTrnxMonth(long trxMonth);

}
