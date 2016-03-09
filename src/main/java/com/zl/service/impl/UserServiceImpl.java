package com.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.TUsermxMapper;
import com.zl.model.TUsermx;
import com.zl.service.UserServiceI;

@Service("userService")
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private TUsermxMapper tUsermxMapper;

	@Override
	public void addUser(TUsermx user) {
		// TODO Auto-generated method stub
		tUsermxMapper.insert(user);

	}

	@Override
	public TUsermx getUserById(String userId) {
		// TODO Auto-generated method stub
		return tUsermxMapper.selectByPrimaryKey(Integer.parseInt(userId));
	}

	@Override
	public int delUser(int userId) {
		// TODO Auto-generated method stub
		int i = tUsermxMapper.deleteByPrimaryKey(userId);
		// System.out.println(i);
		return i;
	}

	@Override
	public List<TUsermx> getAllUser() {
		// TODO Auto-generated method stub
		return tUsermxMapper.getAllUser();
	}

}
