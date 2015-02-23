package org.nammabank.hibernatedao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.nammabank.modelObjects.Address;
import org.nammabank.modelObjects.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserInfoDaoImpl implements UserInfoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public UserInfo getUserInfo(int userId) {
		Session sess = getSessionFactory().getCurrentSession();
		return (UserInfo) sess.get(UserInfo.class, userId);
	}

	@Override
	public void saveUser(UserInfo user) {
		Session sess = getSessionFactory().getCurrentSession();
		sess.save(user);
		System.out.println("saved from userdaoimpl");
	}
	
	@Override
	public List<UserInfo> getAllUsers(String groupId) {
		String hql = "select u from UserInfo u where ";
		Session sess = getSessionFactory().getCurrentSession();
		List<UserInfo> allUser = (List<UserInfo>) sess.createQuery(hql).list();
		return allUser;
	}

	@Override
	public void updateUser(UserInfo user) {
		getSessionFactory().getCurrentSession().update(user);

	}

	@Override
	public Boolean validateUser(int userId) {
		// TODO Auto-generated method stub

		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
