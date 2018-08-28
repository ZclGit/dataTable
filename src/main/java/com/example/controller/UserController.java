package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("batchDelete")
    public Map<String, Object> batchDelete(@RequestBody Map<String,Object> params) {
        Map<String, Object> map = new HashMap<>();
        int i = userService.batchDelete((Integer) params.get("sinceNum"));
        if (i > 0) {
            map.put("result",1);
        }else{
            map.put("result", -1);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/batchAddUser")
    public Map<String, Object> batchAddUser() {
        Map<String, Object> map = new HashMap<>();
        int i = userService.batchAddUser();
        if(i > 0){
            map.put("result", 1);
        }else{
            map.put("result",-1);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/addUser", produces = {"application/json;charset=UTF-8"})
    public Map<String,Object> addUser(@RequestBody User user){
        HashMap<String, Object> map = new HashMap<>();
        int i = userService.addUser(user);
        System.out.println(user.getUserId());
        if(i > 0){
            map.put("result", 1);
        }else{
            map.put("result",-1);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/getAllUserLimit")
    public Map<String, Object> getAllUserLimit(@RequestBody Map<String,Object> params) {
        Map<String,Object> map = userService.getAllUserLimit(params);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/getAllUser")
    public Map<String,Object> getAllUser(){
        Map<String, Object> map = new HashMap<>();
        List<User> userList = userService.getAllUser();
        map.put("data",userList);
        return map;
    }
}
