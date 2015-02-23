package org.nammabank.transaction.controller;

import java.util.List;

import org.nammabank.modelObjects.GroupDetails;
import org.nammabank.transaction.objects.TemplateForms;
import org.nammabank.transaction.services.TrnxMnthAndTemplateService;
import org.nammabank.utility.TransactionMonth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/template")
public class TrnxMnthAndTemplateController {
	
	
	
	@Autowired
	private TrnxMnthAndTemplateService trnxMnthAndTemplateService;
	
	/*
	 First two are related to get template details - only get - as these are standard 
	 and need full approval to change anything*/  
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public TemplateForms getTemplateDetails(@PathVariable("id") int templId) {
		return (TemplateForms) getTempMonthService().getTemplateDetails(templId);
		}
	
	@RequestMapping(value = "allTemplDetail", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<TemplateForms> getGroupList() {
		List<TemplateForms> groups = getTempMonthService().getTempList();
		return groups;
	}
	
	/*
	 Below are related to get transaction month details - only get - as these are standard 
	 and need full approval to change anything - done by developer at DB level for now*/ 
	
	@RequestMapping(value = "getMonth/{id}", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public TransactionMonth getTrnxMonth(@PathVariable("id") long trxMonth) {
		return (TransactionMonth) getTempMonthService().getTrnxMonth(trxMonth);
		}
	
	@RequestMapping(value = "allTrnxMonthDetail", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<TransactionMonth> getAllTrnxMonths() {
		List<TransactionMonth> groups = getTempMonthService().getTrnxMonthList();
		return groups;
	}
	
	
	
	

	public TrnxMnthAndTemplateService getTempMonthService() {
		return trnxMnthAndTemplateService;
	}

	public void setTempMonthService(TrnxMnthAndTemplateService tempMonthService) {
		this.trnxMnthAndTemplateService = tempMonthService;
	}

}
