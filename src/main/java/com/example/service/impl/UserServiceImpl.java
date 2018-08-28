package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.*;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int batchDelete(Integer sinceNum) {
        return userMapper.deleteBatch(sinceNum);
    }

    @Override
    @Transactional
    public int batchAddUser() {
        ArrayList<User> userList = new ArrayList<>();
        Map<String, Object> map = new HashMap<String, Object>();
        for(int i = 0,j=0; i < 10; i++){
            User user = new User();
            Random random = new Random();
            user.setUserName("GeneratePerson"+ ++j);
            user.setPhone(i + random.nextInt(20)*12345+"");
            userList.add(user);
        }
        map.put("userList",userList);
        int i = userMapper.insertSelectiveBatch(userList);
        System.out.println(userList);
        return i;
    }

    @Override
    @Transactional
    public int addUser(User user){
        return userMapper.insertSelective(user);

    }

    @Override
    public Map<String, Object> getAllUserLimit(Map<String,Object> params) {
        Map<String,Object> map = new HashMap<>();
        Page<Object> page = PageHelper.startPage((Integer) params.get("pageNum"), (Integer) params.get("pageSize"));
        List<User> userList = userMapper.selectAllUser();
        map.put("data",userList);
        map.put("pages",page.getPages());
        return map;
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAllUser();
    }


}
