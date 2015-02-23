package org.nammabank.transaction.controller;

import java.util.List;

import org.nammabank.transaction.objects.SavingsTransactions;
import org.nammabank.transaction.services.SavingsTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/savingTranx")
public class SavingsTransactionController {

	@Autowired
	private SavingsTransactionService savingsTransactionService;
	
	@RequestMapping(value = "get/{id}/{id2}", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public SavingsTransactions getSavingTrxDetails(@PathVariable("id") int userId,@PathVariable("id2") int yearComboId) {
		return (SavingsTransactions) getSavingsTransactionService().getSavingTransactions(userId, yearComboId);
	}

	@RequestMapping(value = "allSavingTxDetail/{id}/{id2}", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<SavingsTransactions> getSavingTrxList(@PathVariable("id") int userId,@PathVariable("id") int year) {
		List<SavingsTransactions> SavingTxs = getSavingsTransactionService().getSavingTrxList(userId, year);
		return SavingTxs;
	}

	@RequestMapping(value = "saveSavingTxDetail", method = RequestMethod.POST, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	public void saveSavingTx(@RequestBody SavingsTransactions savingTx) {
		getSavingsTransactionService().addSavingTransactions(savingTx);
	}

	@RequestMapping(value = "updateSavingTxDetail", method = RequestMethod.PUT, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	public void updateSavingTx(@RequestBody SavingsTransactions savingTx) {
		getSavingsTransactionService().updateSavingTransactions(savingTx);
	}

	@RequestMapping(value = "deleteSavingTxDetail", method = RequestMethod.DELETE, consumes = { "application/json" })
	@ResponseBody
	public void deleteSavingTxDetail(@RequestBody SavingsTransactions savingTx) {
		getSavingsTransactionService().deleteSavingTransactions(savingTx);
	}

	public SavingsTransactionService getSavingsTransactionService() {
		return savingsTransactionService;
	}

	public void setSavingsTransactionService(
			SavingsTransactionService savingsTransactionService) {
		this.savingsTransactionService = savingsTransactionService;
	}
	
	
}
