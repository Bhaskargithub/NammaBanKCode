package org.nammabank.service;

import java.util.List;

import org.nammabank.modelObjects.GroupDetails;

/**
 * 
 * @author Bhaskar
 * Bean to manage Group Details of each group
 *
 */

public interface GroupDetailService {

	public void addGroupDetails(GroupDetails group);
	
	public List<GroupDetails> getGroupList();
	
	public void deleteGroupDetails(GroupDetails group);
	
	
	public void updateGroupDetails(GroupDetails group);
	
	
	public GroupDetails getGroupDetails(int accountId);
		
}
