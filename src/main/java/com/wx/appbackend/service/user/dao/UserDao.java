package com.wx.appbackend.service.user.dao;

import com.wx.appbackend.service.user.entity.User;
import com.wx.appbackend.service.user.entity.UserPageDto;
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