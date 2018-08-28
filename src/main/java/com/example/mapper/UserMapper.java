package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteBatch(Integer sinceNum);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    int insertSelectiveBatch(List<User> userList);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAllUser();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}