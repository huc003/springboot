package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.model.Menu;

public interface MenuMapper {

	int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    List<Menu> selectMenuList();
    
    List<Menu> selectUpperLevelMenuList();
    
    List<Menu> selectMenuListByUser(@Param(value="menu") String menu);
    
    List<Menu> selectUpperLevelMenuListByUser(@Param(value="menu") String menu);
}