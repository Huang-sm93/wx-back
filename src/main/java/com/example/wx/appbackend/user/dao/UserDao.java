package com.example.wx.appbackend.user.dao;

import com.example.wx.appbackend.user.entity.User;
import com.example.wx.appbackend.user.entity.UserPageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    int deleteByPrimaryKey(Long key)throws Exception;

    int insert(User user)throws Exception;

    UserPageDto selectById(Long key)throws Exception;

    List<UserPageDto> getPage(Map<String, Object> key)throws Exception;

    int updateByPrimaryKey(User user) throws Exception;
}