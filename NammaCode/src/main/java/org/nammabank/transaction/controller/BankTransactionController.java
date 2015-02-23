package org.nammabank.transaction.controller;

import java.util.List;

import org.nammabank.transaction.objects.BankTransactions;
import org.nammabank.transaction.services.BankTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/bankTranx")
public class BankTransactionController {

	@Autowired
	private BankTransactionService bankTransactionService;

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public BankTransactions getBankTrxDetails(@PathVariable("id") long templId) {
		return (BankTransactions) getBankTransactionService()
				.getBankTransactions(templId);
	}

	@RequestMapping(value = "allBankTxDetail", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<BankTransactions> getBankTrxList() {
		List<BankTransactions> BankTxs = getBankTransactionService()
				.getBankTrxList();
		return BankTxs;
	}

	@RequestMapping(value = "saveBankTxDetail", method = RequestMethod.POST, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	public void saveBankTx(@RequestBody BankTransactions bankTx) {
		getBankTransactionService().addBankTransactions(bankTx);
	}

	@RequestMapping(value = "updateBankTxDetail", method = RequestMethod.PUT, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	public void updateBankTx(@RequestBody BankTransactions bankTx) {
		getBankTransactionService().updateBankTransactions(bankTx);
	}

	@RequestMapping(value = "deleteBankTxDetail", method = RequestMethod.DELETE, consumes = { "application/json" })
	@ResponseBody
	public void deleteBankTxDetail(@RequestBody BankTransactions bankTx) {
		getBankTransactionService().deleteBankTransactions(bankTx);
	}

	public BankTransactionService getBankTransactionService() {
		return bankTransactionService;
	}

	public void setBankTransactionService(
			BankTransactionService bankTransactionService) {
		this.bankTransactionService = bankTransactionService;
	}

}
