package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserMapper;
import com.example.model.User;
import com.example.request.model.UserRequestBean;
import com.example.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> selectUserList(UserRequestBean record) {
		return userMapper.selectUserList(record);
	}

	@Override
	public int selectUserCount(UserRequestBean record) {
		return userMapper.selectUserCount(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer userId) {
		return userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

}
