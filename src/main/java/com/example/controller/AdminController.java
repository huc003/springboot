package com.example.controller;

import com.example.bean.AdminBean;
import com.example.result.bean.AdminBeanResult;
import com.example.utils.TimeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by huc on 2017/8/25.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/admin")
    public String admin(ModelMap map, AdminBean adminBean){
        map.addAttribute("admin",adminBean);
        AdminBeanResult admin = null;
        List<AdminBeanResult> list = new ArrayList<AdminBeanResult>();
        for (int i = 0; i < 150; i++) {
            admin = new AdminBeanResult();
            admin.setId(i);
            admin.setUsername("zhangsan"+i);
            admin.setName("lisi"+i);
            admin.setAddtime(TimeUtils.getCurrentTime("yyyy-MM-dd hh:mm:ss",new Date().getTime()/1000));
            admin.setState(1);
            list.add(admin);
        }
        map.addAttribute("list",list);
        return "user/admin";
    }

    @RequestMapping("/role")
    public String role(){
        return "user/role";
    }
}
