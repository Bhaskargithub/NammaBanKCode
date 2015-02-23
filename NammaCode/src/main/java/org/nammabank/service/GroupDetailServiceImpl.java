package org.nammabank.service;

import java.util.List;

import org.nammabank.hibernatedao.BankAndGroupDetailDao;
import org.nammabank.modelObjects.GroupDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("groupDetailServiceImpl")
public class GroupDetailServiceImpl implements GroupDetailService {

	@Autowired
	private BankAndGroupDetailDao bankAndGroupDetailDao;
	
	@Override
	public void addGroupDetails(GroupDetails group) {
		getBankAndGroupDetailDao().saveGroupDetail(group);
		
	}

	@Override
	public List<GroupDetails> getGroupList() {
		return getBankAndGroupDetailDao().getAllGroups();
		
	}

	@Override
	public void deleteGroupDetails(GroupDetails group) {
		getBankAndGroupDetailDao().deleteGroup(group);
		
	}

	@Override
	public void updateGroupDetails(GroupDetails group) {
		getBankAndGroupDetailDao().updateGroup(group);
		
	}

	@Override
	public GroupDetails getGroupDetails(int accountId) {
		return getBankAndGroupDetailDao().getGroupDetail(accountId);
		
	}

	public BankAndGroupDetailDao getBankAndGroupDetailDao() {
		return bankAndGroupDetailDao;
	}

	public void setBankAndGroupDetailDao(BankAndGroupDetailDao bankAndGroupDetailDao) {
		this.bankAndGroupDetailDao = bankAndGroupDetailDao;
	}

}
