package com.wx.appbackend.service;

import com.wx.appbackend.service.myaccount.entity.MyAccountEntity;
import com.wx.appbackend.service.myaccount.entity.MyAccountReqDTO;
import com.wx.appbackend.service.myaccount.entity.MyAccountResDTO;
import com.wx.appbackend.service.user.entity.UserEntity;
import com.wx.appbackend.service.user.entity.UserReqDto;
import com.wx.appbackend.service.user.entity.UserResDto;

/**
 * @Author: sm.huang
 * @Date: 2024/6/13  09:41
 **/
public class ItemConvert {

    public static UserEntity toUserEntity(UserReqDto userReqDto) {
        if (userReqDto == null) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.id = userReqDto.id;
        userEntity.userName = userReqDto.userName;
        userEntity.account = userReqDto.account;
        userEntity.password = userReqDto.password;
        userEntity.birthday = userReqDto.birthday;
        userEntity.sex = userReqDto.sex;
        userEntity.phoneNumber = userReqDto.phoneNumber;
        return userEntity;
    }

    public static UserResDto toUserResDto(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        UserResDto userResDto = new UserResDto();
        userResDto.id = userEntity.id;
        userResDto.account = userEntity.account;
        userResDto.userName = userEntity.userName;
        userResDto.password = userEntity.password;
        userResDto.birthday = userEntity.birthday;
        userResDto.sex = userEntity.sex;
        userResDto.phoneNumber = userEntity.phoneNumber;
        userResDto.createTime = userEntity.createTime;
        userResDto.updateTime = userEntity.updateTime;
        userResDto.lastLogin = userEntity.lastLogin;
        return userResDto;
    }

    public static MyAccountEntity toMyAccountEntity(MyAccountReqDTO reqDTO) {
        if (reqDTO == null) {
            return null;
        }
        MyAccountEntity myAccountEntity = new MyAccountEntity();
        myAccountEntity.id = reqDTO.id;
        myAccountEntity.userId = reqDTO.userId;
        myAccountEntity.amount = reqDTO.amount;
        return myAccountEntity;
    }

}
