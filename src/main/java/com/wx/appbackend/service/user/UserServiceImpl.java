package com.wx.appbackend.service.user;

import com.wx.appbackend.service.user.dao.UserDao;
import com.wx.appbackend.service.user.entity.User;
import com.wx.appbackend.service.user.entity.UserResDto;
import com.wx.appbackend.service.user.entity.UserReqDto;
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
    public UserResDto get(Long id) throws Exception {
        return userDao.selectById(id);
    }

    @Override
    public List<UserResDto> getPage(Map<String, Object> map) throws Exception {
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
