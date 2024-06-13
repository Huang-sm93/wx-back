package com.wx.appbackend.service.user;

import com.wx.appbackend.service.ItemConvert;
import com.wx.appbackend.service.user.dao.UserDao;
import com.wx.appbackend.service.user.entity.UserEntity;
import com.wx.appbackend.service.user.entity.UserResDto;
import com.wx.appbackend.service.user.entity.UserReqDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public UserResDto get(Long id) throws Exception {
        UserResDto resDto = ItemConvert.toUserResDto(userDao.selectById(id));
        return resDto;
    }

    @Override
    public List<UserResDto> getPage(UserReqDto reqDto) throws Exception {
        int pageIndex = reqDto.pageIndex;
        int pageSize = reqDto.pageSize;
        List<UserEntity> userEntities = userDao.getPage(pageIndex, pageSize);
        return userEntities.stream().map(ItemConvert::toUserResDto).collect(Collectors.toList());
    }

    @Override
    public int insert(UserReqDto userReqDto) throws Exception {
        UserEntity userEntity = ItemConvert.toUserEntity(userReqDto);
        if (userEntity == null) {
            return 0;
        }
        userEntity.updateTime = new Timestamp(System.currentTimeMillis());
        userEntity.createTime = userEntity.updateTime;
        return userDao.insert(userEntity);
    }

    @Override
    public int update(UserReqDto userReqDto) throws Exception {
        UserEntity userEntity = ItemConvert.toUserEntity(userReqDto);
        if (userEntity == null) {
            return 0;
        }
        userEntity.updateTime = new Timestamp(System.currentTimeMillis());
        return userDao.update(userEntity);
    }
}
