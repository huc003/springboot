package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huc on 2017/8/24.
 */
@Controller
@RequestMapping("/main")
public class MainController {

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
    public String content(ModelMap map,String url,String id){
        map.addAttribute("url", url);
        map.addAttribute("id", id);
        return "main/index";
    }


}
