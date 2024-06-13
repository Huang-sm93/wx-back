package com.wx.appbackend.service.user.dao;

import com.wx.appbackend.service.user.entity.UserEntity;
import com.wx.appbackend.service.user.entity.UserResDto;
import org.apache.ibatis.annotations.Flush;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    int delete(Long key)throws Exception;

    int insert(UserEntity userEntity)throws Exception;

    UserEntity selectById(Long key)throws Exception;

    List<UserEntity> getPage(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize)throws Exception;

    int update(UserEntity userEntity) throws Exception;
}