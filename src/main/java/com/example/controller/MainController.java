package com.example.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Admin;
import com.example.model.Menu;
import com.example.service.MenuService;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Created by huc on 2017/8/24.
 */
@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	private MenuService menuService;

    @RequestMapping("/top")
    public String top(){
        return "main/top";
    }

    @RequestMapping("/main")
    public String main(){
        return "main/main";
    }

    @RequestMapping("/left")
    public String left(){
        return "main/left";
    }

    @RequestMapping("/content")
    public String content(ModelMap map,String url,String id,HttpServletRequest request){
    	Admin user = (Admin)request.getSession().getAttribute("admin");
    	if(user==null||user.getName().equals("")){
    		return "redirect:/admin/out.html";
    	}
    	if(url==null){
    		url = "/main/main";
    	}
        map.addAttribute("url", url);
        map.addAttribute("id", id);
        map.addAttribute("fmenu_list", new ArrayList<Menu>());
		map.addAttribute("zmenu_list", new ArrayList<Menu>());
        if(user.getMenu()!=null&&!user.getMenu().equals("")){
        	map.addAttribute("fmenu_list", menuService.selectUpperLevelMenuListByUser(user.getMenu()));
    		map.addAttribute("zmenu_list", menuService.selectMenuListByUser(user.getMenu()));
        }
        return "main/index";
    }


}
