package org.nammabank.controller;

import java.util.List;

import org.nammabank.modelObjects.BankDetail;
import org.nammabank.service.BankDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/bankDetail")
public class BankDetailRestService {

	@Autowired
	private BankDetailService bankDetailService;

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public BankDetail getBankDetail(@PathVariable("id") int bankId) {
		System.out.println("inside rest get" + bankId);
		BankDetail bank = (BankDetail) getBankDetailService().getBankDetail(
				bankId);
		System.out.println(bank.getBankName());
		return bank;
	}

	@RequestMapping(value = "allBankDetail", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<BankDetail> getBankList() {
		List<BankDetail> allBanks = getBankDetailService().getBankList();
		return allBanks;
	}

	@RequestMapping(value = "saveBankDetail", method = RequestMethod.POST, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	public void saveUser(@RequestBody BankDetail bank) {
		getBankDetailService().addBankDetail(bank);
	}

	@RequestMapping(value = "updateBankDetail", method = RequestMethod.PUT, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	public void updateUser(@RequestBody BankDetail bank) {
		getBankDetailService().updateBankDetail(bank);
	}

	@RequestMapping(value = "deleteBankDetail", method = RequestMethod.DELETE, consumes = { "application/json" })
	@ResponseBody
	public void deleteBankDetail(@RequestBody BankDetail bank) {
		getBankDetailService().deleteBankDetail(bank);
	}

	public BankDetailRestService() {

	}

	public BankDetailService getBankDetailService() {
		return bankDetailService;
	}

	public void setBankDetailService(BankDetailService bankDetailService) {
		this.bankDetailService = bankDetailService;
	}

}
