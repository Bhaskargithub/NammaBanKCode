package org.nammabank.service;

import java.util.List;

import org.nammabank.modelObjects.BankDetail;
import org.springframework.stereotype.Service;



public interface BankDetailService {

	public void addBankDetail(BankDetail bank);
	
	
	public void deleteBankDetail(BankDetail bank);
	
	
	public void updateBankDetail(BankDetail bank);
	
	
	public BankDetail getBankDetail(int bankId);
	
	
	public List<BankDetail> getBankList();


	
}
