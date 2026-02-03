package com.group5.service.impl;

import com.group5.dao.UserDAO;
import com.group5.model.User;
import com.group5.service.UserService;

public class UserServiceImpl implements UserService {
	
	private final UserDAO userDAO;
	
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public User isUserExisting(String id, String username) {
		return userDAO.isUserExisting(id, username);
	}
}
