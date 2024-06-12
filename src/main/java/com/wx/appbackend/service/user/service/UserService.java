package com.wx.appbackend.service.user.service;

import com.wx.appbackend.service.user.entity.UserPageDto;
import com.wx.appbackend.service.user.entity.UserReqDto;

import java.util.List;
import java.util.Map;

public interface UserService {

    UserPageDto get(Long id)throws Exception;

    List<UserPageDto> getPage(Map<String, Object> map) throws Exception;

    int insert(UserReqDto user) throws Exception;

    int update(UserReqDto user) throws Exception;
}
