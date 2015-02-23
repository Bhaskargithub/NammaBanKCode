package org.nammabank.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nammabank.modelObjects.UserInfo;
import org.springframework.stereotype.Component;


/**
 * 
 * @author Bhaskar
 * Handle all user functionalities - individual and group
 */

public interface UserServiceIntf {
	
	public UserInfo getUserInfo(int userId);
	
	
	public void updateUser(UserInfo user);

	public void saveUser(UserInfo user);
	
		
	public void createUser(UserInfo user);
	
	
	public Boolean validateUser(int userId);
	
	
	public void deleteUserInfo();


	public List<UserInfo> getUserList(String groupId);
	
	
}
