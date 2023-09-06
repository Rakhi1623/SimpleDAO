package com.canddella.service;

import java.util.List;

import com.canddella.entity.User;

public interface UserService {
	User searchUser(String user_id);

	public void addUser(User user);

	public void updateUser(User user);

	public List<User> ListAllUser();

}



