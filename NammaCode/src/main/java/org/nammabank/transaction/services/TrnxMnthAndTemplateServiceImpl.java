package org.nammabank.transaction.services;

import java.util.List;

import org.nammabank.transaction.dboperations.TrnxMnthAndTemplateQueries;
import org.nammabank.transaction.objects.TemplateForms;
import org.nammabank.utility.TransactionMonth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TrnxMnthAndTemplateServiceImpl implements
		TrnxMnthAndTemplateService {
	
	@Autowired
	private TrnxMnthAndTemplateQueries trnxMnthAndTemplateQueries;

	@Override
	public TemplateForms getTemplateDetails(int templId) {
		
		return (TemplateForms) getTmTlQueries().getTemplateDetail(templId);
	}

	@Override
	public List<TemplateForms> getTempList() {
	   
		return (List<TemplateForms>) getTmTlQueries().getAllTemplates();
	}

	@Override
	public List<TransactionMonth> getTrnxMonthList() {
		
		return (List<TransactionMonth>) getTmTlQueries().getAllTrnxMonth();
	}

	@Override
	public TransactionMonth getTrnxMonth(long trxMonth) {
		return (TransactionMonth) getTmTlQueries().getTrnxMonthDetail(trxMonth);
	}

	public TrnxMnthAndTemplateQueries getTmTlQueries() {
		return trnxMnthAndTemplateQueries;
	}

	public void setTmTlQueries(TrnxMnthAndTemplateQueries tmTlQueries) {
		this.trnxMnthAndTemplateQueries = tmTlQueries;
	}

}
