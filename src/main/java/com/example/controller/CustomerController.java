package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huc on 2017/8/25.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/list")
    public String role(){
        return "user/customer_list";
    }
}
