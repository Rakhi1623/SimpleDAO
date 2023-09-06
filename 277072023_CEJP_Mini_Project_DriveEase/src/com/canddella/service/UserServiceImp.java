package com.canddella.service;

import java.util.List;

import com.canddella.dao.UserDAO;
import com.canddella.dao.UserDAOImp;
import com.canddella.entity.User;

public class UserServiceImp implements UserDAO {
	
	
	UserDAOImp userDAOImp = new UserDAOImp();

	@Override
	public User searchUser(String user_id) {

		return userDAOImp.searchUser(user_id) ;
	}

	@Override
	public void addUser(User user) {
		userDAOImp.addUser(user);

	}

	@Override
	public void updateUser(User user) {
		userDAOImp.updateUser(user);

	}

	@Override
	public List<User> ListAllUser() {
		
		return userDAOImp.ListAllUser();
	}

}
