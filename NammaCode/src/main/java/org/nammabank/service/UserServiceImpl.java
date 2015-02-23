package org.nammabank.service;

import java.util.List;

import org.nammabank.hibernatedao.UserInfoDao;
import org.nammabank.hibernatedao.UserInfoDaoImpl;
import org.nammabank.modelObjects.Address;
import org.nammabank.modelObjects.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceIntf {


	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public UserInfo getUserInfo(int userId) {

		return getUserInfoDao().getUserInfo(userId);
			}

	@Override
	public void saveUser(UserInfo user) {
		getUserInfoDao().saveUser(user);
		
	}


	@Override
	public Boolean validateUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> getUserList(String groupId) {

		List<UserInfo> allUser = getUserInfoDao().getAllUsers(groupId);
		
		return allUser;
	}

	@Override
	public void createUser(UserInfo user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserInfo() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updateUser(UserInfo user) {
		getUserInfoDao().updateUser(user);
		
	}

	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	

}
