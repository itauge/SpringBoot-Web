package com.example.springbootweb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg","success..");
        request.setAttribute("code",200);
        return "forward:/success"; //轉發到 /success請求
    }

    @ResponseBody
    @RequestMapping("/success")
    public Map success(@RequestAttribute("msg") String msg,
                       @RequestAttribute("code") Integer code,
                       HttpServletRequest request){
        Object msg1 = request.getAttribute("msg");
        Map<String,Object> map = new HashMap<>();
        map.put("request_msg",msg1);
        map.put("annotation_msg",msg);
        return map;
    }
}
