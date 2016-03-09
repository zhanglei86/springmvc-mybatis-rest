package com.zl.service;

import java.util.List;

import com.zl.model.TUsermx;

public interface UserServiceI {
	void addUser(TUsermx user);

	TUsermx getUserById(String userId);
	
	int delUser(int userId);

	List<TUsermx> getAllUser();
	
	
}
