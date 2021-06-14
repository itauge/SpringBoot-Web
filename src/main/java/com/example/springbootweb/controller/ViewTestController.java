package com.example.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {
    @GetMapping("/hey")
    public String hey(Model model){
        //model中的數據會被放在請求域中 request.setAttribute("a","x")
        model.addAttribute("msg","hello");
        model.addAttribute("link","http://www.bing.com");
        return "success";
    }
}
