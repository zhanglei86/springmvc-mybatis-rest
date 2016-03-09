package com.hdy.service;

import java.util.List;

import com.hdy.model.TUsermx;

public interface UserServiceI {
	void addUser(TUsermx user);

	TUsermx getUserById(String userId);
	
	int delUser(int userId);

	List<TUsermx> getAllUser();
	
	
}
