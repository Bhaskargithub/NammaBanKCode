package org.nammabank.hibernatedao;

import java.util.List;

import org.nammabank.modelObjects.UserInfo;

public interface UserInfoDao {

	public UserInfo getUserInfo(int userId);
	
	public void saveUser(UserInfo user);
	
	public List<UserInfo> getAllUsers(String groupId);
	
	public void updateUser(UserInfo user);
	
	public Boolean validateUser(int userId);

}
