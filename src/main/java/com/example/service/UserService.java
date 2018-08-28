package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface UserService {
    int batchDelete(Integer sinceNum);

    int batchAddUser();

    int addUser(User user);

    Map<String,Object> getAllUserLimit(Map<String,Object> params);

    List<User> getAllUser();
}
