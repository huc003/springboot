package com.example.service;

import java.util.List;

import com.example.model.Admin;
import com.example.request.model.AdminRequestBean;


public interface AdminService {
	List<Admin> select(AdminRequestBean record) throws Exception;
	
	int selectCount(AdminRequestBean record);
	
	int deleteAdminUserById(Integer id);
	
	Admin selectByUsername(String username,String password);
	
	Admin selectById(Integer id);
	
	int updatePasswordByIdAndPassword(AdminRequestBean record);
	
	int updateByPrimaryKeySelective(AdminRequestBean record);
}	
