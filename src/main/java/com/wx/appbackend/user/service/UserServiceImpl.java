package com.wx.appbackend.user.service;

import com.wx.appbackend.user.dao.UserDao;
import com.wx.appbackend.user.entity.User;
import com.wx.appbackend.user.entity.UserPageDto;
import com.wx.appbackend.user.entity.UserReqDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public UserPageDto get(Long id) throws Exception {
        return userDao.selectById(id);
    }

    @Override
    public List<UserPageDto> getPage(Map<String, Object> map) throws Exception {
        return userDao.getPage(map);
    }

    @Override
    public int insert(UserReqDto userReqDto) throws Exception {
        User user = new User();
        user.setPasswd(userReqDto.getPasswd());
        user.setUserName(userReqDto.getUserName());
        user.setSex(userReqDto.getSex());
        user.setCreateDate(new Date());
        user.setLastUpdateDate(new Date());
        return userDao.insert(user);
    }

    @Override
    public int update(UserReqDto userReqDto) throws Exception {
        User user = new User();
        user.setPasswd(userReqDto.getPasswd());
        user.setUserName(userReqDto.getUserName());
        user.setSex(userReqDto.getSex());
        user.setId(userReqDto.getId());
        user.setLastUpdateDate(new Date());
        return userDao.updateByPrimaryKey(user);
    }
}
