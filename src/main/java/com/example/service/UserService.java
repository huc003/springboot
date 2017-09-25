package com.example.service;

import java.util.List;

import com.example.model.User;
import com.example.request.model.UserRequestBean;

public interface UserService {
	List<User> selectUserList(UserRequestBean record);
    
    int selectUserCount(UserRequestBean record);
    
    int deleteByPrimaryKey(Integer userId);
    
    User selectByPrimaryKey(Integer id);
}
