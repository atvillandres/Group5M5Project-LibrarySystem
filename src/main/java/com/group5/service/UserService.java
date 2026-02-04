package com.group5.service;

import com.group5.model.User;

public interface UserService {
	User isUserExisting(String id, String username);
}
