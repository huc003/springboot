package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.Admin;
import com.example.request.model.AdminRequestBean;
import com.example.request.model.MenuRequestBean;
import com.example.service.AdminService;
import com.example.service.MenuService;

/**
 * Created by huc on 2017/8/25.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private AdminService adminService;

    @RequestMapping("/admin")
    public String admin(ModelMap map, AdminRequestBean admin,BindingResult bindingResult) throws Exception{
        map.addAttribute("admin",admin);
        map.addAttribute("list",adminService.select(admin));
        map.addAttribute("total",admin.getTotal(adminService.selectCount(admin), admin.getRows()));
        map.addAttribute("count",adminService.selectCount(admin));
        return "user/admin_list";
    }
    
    @RequestMapping("/edit.html")
    public String editPage(ModelMap map, AdminRequestBean admin) throws Exception{
    	//查询出用的信息
    	Admin user = adminService.selectById(admin.getId());
    	map.addAttribute("admin",user);
    	//菜单菜单权限
    	map.addAttribute("fmenu_list", menuService.selectUpperLevelMenuList());
		map.addAttribute("zmenu_list", menuService.selectMenuList());
		//用户菜单菜单权限
    	map.addAttribute("user_fmenu_list", menuService.selectUpperLevelMenuListByUser(user.getMenu()));
		map.addAttribute("user_zmenu_list", menuService.selectMenuListByUser(user.getMenu()));
		//是否勾选用户菜单
		if(user.getMenu()==null||user.getMenu().equals("")){
			map.addAttribute("is_check",0);
		}else{
			map.addAttribute("is_check",1);
		}
    	return "user/edit_admin";
    }
    
    @RequestMapping("/edit")
    public String edit(ModelMap map, AdminRequestBean admin) throws Exception{
    	int id = adminService.updateByPrimaryKeySelective(admin);
    	Admin user = adminService.selectById(admin.getId());
    	map.addAttribute("admin",user);
    	if(id>0){
    		map.addAttribute("is_display",1);
        }else{
        	map.addAttribute("is_display",0);
        }
    	//菜单菜单权限
    	map.addAttribute("fmenu_list", menuService.selectUpperLevelMenuList());
		map.addAttribute("zmenu_list", menuService.selectMenuList());
		//用户菜单菜单权限
    	map.addAttribute("user_fmenu_list", menuService.selectUpperLevelMenuListByUser(user.getMenu()));
		map.addAttribute("user_zmenu_list", menuService.selectMenuListByUser(user.getMenu()));
		//是否勾选用户菜单
		if(user.getMenu()==null||user.getMenu().equals("")){
			map.addAttribute("is_check",0);
		}else{
			map.addAttribute("is_check",1);
		}
    	return "user/edit_admin";
    }
    
    @RequestMapping("/edit_menu")
    public String edit_menu(ModelMap map, AdminRequestBean admin) throws Exception{
    	admin.setMenu(admin.getMenu().substring(0, admin.getMenu().length()-1));
		int id = adminService.updateByPrimaryKeySelective(admin);
    	if(id>0){
    		map.addAttribute("is_display",1);
        }else{
        	map.addAttribute("is_display",0);
        }
    	Admin user = adminService.selectById(admin.getId());
    	//查询出用的信息
    	map.addAttribute("admin",user);
    	//菜单菜单权限
    	map.addAttribute("fmenu_list", menuService.selectUpperLevelMenuList());
		map.addAttribute("zmenu_list", menuService.selectMenuList());
		//用户菜单菜单权限
    	map.addAttribute("user_fmenu_list", menuService.selectUpperLevelMenuListByUser(user.getMenu()));
		map.addAttribute("user_zmenu_list", menuService.selectMenuListByUser(user.getMenu()));
		//是否勾选用户菜单
		if(user.getMenu()==null||user.getMenu().equals("")){
			map.addAttribute("is_check",0);
		}else{
			map.addAttribute("is_check",1);
		}
    	return "user/edit_admin";
    }
    
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(ModelMap map, AdminRequestBean admin) throws Exception{
        map.addAttribute("admin",admin);
        int id = adminService.deleteAdminUserById(admin.getId());
        if(id>0){
        	return "success";
        }else{
        	return "fail";
        }
    }
    
    @RequestMapping("/out.html")
    public String out(ModelMap map,String status,String message,String username,HttpServletRequest request) throws Exception{
    	map.addAttribute("status", status);
		map.addAttribute("message", message);
		map.addAttribute("username", username);
		request.getSession().removeAttribute("admin");
        return "user/login";
    }
    
    @RequestMapping("/login")
    public String login(ModelMap map,AdminRequestBean admin,HttpServletRequest request,RedirectAttributes attr,BindingResult bindingResult) throws Exception{
    	Admin user = adminService.selectByUsername(admin.getUsername(), admin.getPassword());
    	attr.addAttribute("username", admin.getUsername());
    	if(user.getStatus()==0){
    		attr.addAttribute("status", "0");
    		attr.addAttribute("message", "用户不存在");
    		return "redirect:/admin/out.html";
    	}else if(user.getStatus()==1){
    		attr.addAttribute("status", "1");
    		attr.addAttribute("message", "密码错误");
    		return "redirect:/admin/out.html";
    	}else if(user.getStatus()==2){
    		attr.addAttribute("status", "2");
    		attr.addAttribute("message", "用户已注销");
    		return "redirect:/admin/out.html";
    	}
    	request.getSession().setAttribute("admin", user);
    	return "redirect:/main/content";
    }

    @RequestMapping("/role")
    public String role(){
        return "user/role";
    }
    
    @RequestMapping("/update_pwd.html")
    public String updatePwdPage(){
        return "user/update_pwd";
    }
    
    @RequestMapping("/update_password")
    public String updatePwd(ModelMap map,AdminRequestBean admin,HttpServletRequest request,BindingResult bindingResult){
    	Admin user = (Admin)request.getSession().getAttribute("admin");
    	admin.setId(user.getId());
    	int n = adminService.updatePasswordByIdAndPassword(admin);
    	map.addAttribute("status", n);
        return "user/update_pwd";
    }
    
    
    
}
