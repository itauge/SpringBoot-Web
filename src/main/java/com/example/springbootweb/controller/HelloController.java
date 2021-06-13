package com.example.springbootweb.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.reactive.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class HelloController {

    @RequestMapping("/car/{id}/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String username,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String useragent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("interest")List<String> interest,
                                     @CookieValue Cookie cookie,
                                     @RequestBody String content){

        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("username",username);
        map.put("pv",pv);
        map.put("useragent",useragent);
        map.put("header",header);
        map.put("interest",interest);
        System.out.println(cookie);

        return map;
    }

    @RequestMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }

//    1. 語法:/cars/sell;low=34;brand=byd,audi
//    2.SpringBoot默認是禁用了矩陣變量的功能
//    手動開啓:原理 對於路徑的處理.UrlPathHelper進行解析. removeSemicolonContent(移除分號内容) 支持矩陣變量
    @GetMapping("/cars/{path}")
    public Map<String, Object> carSell(@MatrixVariable("low") Integer low,
                                       @MatrixVariable("brand") List<String> brand,
                                       @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }

//    /boss/1;age=12/2;age=12
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
        Map<String,Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;
    }

    @RequestMapping("/hello.jpg")
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "GET-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(){
        return "POST-张三";
    }


    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "PUT-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE-张三";
    }




}
