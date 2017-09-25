package com.example.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.model.User;
import com.example.request.model.UserRequestBean;

public interface UserMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectUserList(@Param(value="record")UserRequestBean record);
    
    int selectUserCount(@Param(value="record")UserRequestBean record);
}