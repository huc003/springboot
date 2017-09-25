package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MenuMapper;
import com.example.model.Menu;
import com.example.request.model.MenuRequestBean;
import com.example.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<Menu> selectMenuList() {
		return menuMapper.selectMenuList();
	}

	@Override
	public List<Menu> selectUpperLevelMenuList() {
		return menuMapper.selectUpperLevelMenuList();
	}

	@Override
	public List<Menu> selectMenuListByUser(String menu) {
		return menuMapper.selectMenuListByUser(menu);
	}

	@Override
	public List<Menu> selectUpperLevelMenuListByUser(String menu) {
		return menuMapper.selectUpperLevelMenuListByUser(menu);
	}
	
}
