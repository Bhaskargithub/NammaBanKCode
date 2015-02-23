package org.nammabank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nammabank.hibernatedao.UserInfoDao;
import org.nammabank.modelObjects.UserInfo;
import org.nammabank.service.UserServiceImpl;
import org.nammabank.service.UserServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
@RequestMapping(value="/userInfo")
public class UserInfoRestService {

	
	@Autowired
	private UserServiceIntf userServ;
	
	
	
	@RequestMapping(value="get/{id}", method = RequestMethod.GET, produces={"application/json"} )
	@ResponseBody
	public UserInfo getUserInfo(@PathVariable("id") int userId){
		UserInfo user = (UserInfo) getUserServ().getUserInfo(userId);
		return user;
	}
	
	@RequestMapping(value="allUsers/{groupId}", method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public List<UserInfo> getUserList(@PathVariable("groupId") String groupId){
		List<UserInfo> allUsers = getUserServ().getUserList(groupId);
		return allUsers;
	}
	
	
	@RequestMapping(value="saveUser", method = RequestMethod.POST, produces={"application/json"},consumes = {"application/json"})
	@ResponseBody
	public void saveUser(@RequestBody UserInfo user){
		
		getUserServ().saveUser(user);
	}
	
	@RequestMapping(value="updateUser", method = RequestMethod.PUT, produces={"application/json"},consumes = {"application/json"})
	@ResponseBody
	public void updateUser(@RequestBody UserInfo user){
		getUserServ().updateUser(user);
	}
	
	@RequestMapping(value="deleteUser", method = RequestMethod.DELETE, consumes={"application/json"})
	@ResponseBody
	public void deleteUser( UserInfo user){
		
		
	}
	
	public UserServiceIntf getUserServ() {
		return userServ;
	}

	public void setUserServ(UserServiceIntf userServ) {
		this.userServ = userServ;
	}
	
	
}
