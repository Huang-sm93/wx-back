package com.wx.appbackend.user.service;

import com.wx.appbackend.user.entity.UserPageDto;
import com.wx.appbackend.user.entity.UserReqDto;

import java.util.List;
import java.util.Map;

public interface UserService {

    UserPageDto get(Long id)throws Exception;

    List<UserPageDto> getPage(Map<String, Object> map) throws Exception;

    int insert(UserReqDto user) throws Exception;

    int update(UserReqDto user) throws Exception;
}
