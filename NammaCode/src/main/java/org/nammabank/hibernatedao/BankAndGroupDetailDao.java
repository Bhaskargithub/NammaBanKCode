package org.nammabank.hibernatedao;

import java.util.List;

import org.nammabank.modelObjects.GroupDetails;
import org.nammabank.modelObjects.SavingsAccountDetails;
import org.nammabank.modelObjects.BankDetail;
import org.nammabank.modelObjects.UserInfo;

public interface BankAndGroupDetailDao {

	

	public BankDetail getBankDetail(int bankId);
	
	public void saveBankDetail(BankDetail user);
	
	public List<BankDetail> getAllBanks();
	
	public void updateBank(BankDetail bank);
	
	public void deleteBank(BankDetail bank);

	// Interfaces related to GROUP TABLE and operations
	
	public GroupDetails getGroupDetail(int bankId);
	
	public void saveGroupDetail(GroupDetails group);
	
	public List<GroupDetails> getAllGroups();
	
	public void deleteGroup(GroupDetails group);

	void updateGroup(GroupDetails bank);
	
	
	
	//public Boolean validateUser(int userId);
}
