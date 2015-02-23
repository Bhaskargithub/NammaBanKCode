package org.nammabank.controller;


import java.util.List;

import org.nammabank.modelObjects.BankDetail;
import org.nammabank.modelObjects.GroupDetails;
import org.nammabank.service.GroupDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping(value="/groupDetail")
public class GroupDetailRestService {

	@Autowired
	private GroupDetailService groupDetailService;

	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public GroupDetails getGroupkDetail(@PathVariable("id") int accountId) {
		return (GroupDetails) getGroupDetailService().getGroupDetails(accountId);
		}
	
	@RequestMapping(value = "allGroupDetail", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<GroupDetails> getGroupList() {
		List<GroupDetails> groups = getGroupDetailService().getGroupList();
		return groups;
	}
	
	@RequestMapping(value = "saveGroupDetail", method = RequestMethod.POST, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	public void saveUser(@RequestBody GroupDetails group) {
		getGroupDetailService().addGroupDetails(group);
	}
	
	@RequestMapping(value = "updateGroupDetail", method = RequestMethod.PUT, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	public void updateUser(@RequestBody GroupDetails group) {
		getGroupDetailService().updateGroupDetails(group);
	}

	@RequestMapping(value = "deleteGroupDetail", method = RequestMethod.DELETE, consumes = { "application/json" })
	@ResponseBody
	public void deleteGroupDetail(@RequestBody GroupDetails group) {

	}
	
	
	public GroupDetailService getGroupDetailService() {
		return groupDetailService;
	}

	public void setGroupDetailService(GroupDetailService groupDetailService) {
		this.groupDetailService = groupDetailService;
	}	

	
	
}
