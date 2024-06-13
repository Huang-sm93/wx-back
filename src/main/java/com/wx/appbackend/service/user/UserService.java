package com.wx.appbackend.service.user;

import com.wx.appbackend.service.user.entity.UserResDto;
import com.wx.appbackend.service.user.entity.UserReqDto;

import java.util.List;
import java.util.Map;

public interface UserService {

    UserResDto get(Long id)throws Exception;

    List<UserResDto> getPage(UserReqDto user) throws Exception;

    int insert(UserReqDto user) throws Exception;

    int update(UserReqDto user) throws Exception;
}
