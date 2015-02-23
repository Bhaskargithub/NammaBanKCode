package org.nammabank.service;

import java.util.List;

import org.nammabank.hibernatedao.BankAndGroupDetailDao;
import org.nammabank.modelObjects.BankDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BankDetailServiceImpl implements BankDetailService {

	
	@Override
	public BankDetail getBankDetail(int bankId) {
		
		return getBankDetailDao().getBankDetail(bankId);
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public List<BankDetail> getBankList() {
	
		return getBankDetailDao().getAllBanks();
	}


	@Autowired
	private BankAndGroupDetailDao bankAndGroupDetailDao;
	
	@Override
	public void addBankDetail(BankDetail bank) {
		getBankDetailDao().saveBankDetail(bank);
	}

	@Override
	public void deleteBankDetail(BankDetail bank) {
		getBankDetailDao().deleteBank(bank);
		
	}

	@Override
	public void updateBankDetail(BankDetail bank) {
		getBankDetailDao().updateBank(bank);
		
	}

	
	
	
	public BankAndGroupDetailDao getBankDetailDao() {
		return bankAndGroupDetailDao;
	}

	public void setBankDetailDao(BankAndGroupDetailDao bankAndGroupDetailDao) {
		this.bankAndGroupDetailDao = bankAndGroupDetailDao;
	}


}
