package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.User;
import com.example.request.model.UserRequestBean;
import com.example.service.UserService;

/**
 * Created by huc on 2017/8/25.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private UserService userService;

    @RequestMapping("/list")
    public String list(ModelMap map, UserRequestBean record,BindingResult bindingResult){
    	map.addAttribute("user", record);
    	map.addAttribute("list", userService.selectUserList(record));
    	map.addAttribute("total",record.getTotal(userService.selectUserCount(record), record.getRows()));
    	map.addAttribute("count", userService.selectUserCount(record));
        return "user/customer_list";
    }
    
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(ModelMap map, UserRequestBean record){
    	map.addAttribute("user",record);
        int id = userService.deleteByPrimaryKey(record.getId());
        if(id>0){
        	return "success";
        }else{
        	return "fail";
        }
    }
    
    @RequestMapping("user_info")
    public String userInfo(ModelMap map, UserRequestBean record){
    	User user = userService.selectByPrimaryKey(record.getId());
    	map.addAttribute("user",user);
    	return "user/customer_info";
    }
    
    
    
}
