package com.example.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.model.Admin;
import com.example.request.model.AdminRequestBean;

public interface AdminMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(Admin record);

	int insertSelective(Admin record);

	Admin selectByPrimaryKey(Integer id);
	
	Admin selectByUsername(String username);

	int updateByPrimaryKeySelective(AdminRequestBean record);

	int updateByPrimaryKey(Admin record);

    List<Admin> select(@Param(value="record")AdminRequestBean record);
    
    int selectCount(@Param(value="record")AdminRequestBean record);
    
    int updatePasswordByIdAndPassword(@Param(value="record")AdminRequestBean record);
}