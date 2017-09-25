package com.example.service;

import java.util.List;

import com.example.model.Menu;

public interface MenuService {
	List<Menu> selectMenuList();
	List<Menu> selectUpperLevelMenuList();
	
	List<Menu> selectMenuListByUser(String menu);
	List<Menu> selectUpperLevelMenuListByUser(String menu);
}
