package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.AdminMapper;
import com.example.model.Admin;
import com.example.request.model.AdminRequestBean;
import com.example.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public List<Admin> select(AdminRequestBean record) throws Exception {
		return adminMapper.select(record);
	}

	@Override
	public int selectCount(AdminRequestBean record) {
		return adminMapper.selectCount(record);
	}

	@Override
	public int deleteAdminUserById(Integer id) {
		return adminMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Admin selectByUsername(String username,String password) {
		Admin admin = adminMapper.selectByUsername(username);
		if(admin==null){
			admin = new Admin();
			admin.setStatus(0);
			return admin;
		}
		admin.setStatus(3);
		if(!admin.getPassword().equals(password)){
			admin.setStatus(1);
		}
		if(admin.getStatus()==0){
			admin.setStatus(2);
		}
		return admin;
	}

	@Override
	public int updatePasswordByIdAndPassword(AdminRequestBean record) {
		return adminMapper.updatePasswordByIdAndPassword(record);
	}

	@Override
	public Admin selectById(Integer id) {
		return adminMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(AdminRequestBean record) {
		return adminMapper.updateByPrimaryKeySelective(record);
	}
	
}
