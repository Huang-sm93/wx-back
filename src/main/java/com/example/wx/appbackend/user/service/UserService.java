package com.example.wx.appbackend.user.service;

import com.example.wx.appbackend.user.entity.User;
import com.example.wx.appbackend.user.entity.UserPageDto;
import com.example.wx.appbackend.user.entity.UserReqDto;

import java.util.List;
import java.util.Map;

public interface UserService {

    UserPageDto get(Long id)throws Exception;

    List<UserPageDto> getPage(Map<String, Object> map) throws Exception;

    int insert(UserReqDto user) throws Exception;

    int update(UserReqDto user) throws Exception;
}
