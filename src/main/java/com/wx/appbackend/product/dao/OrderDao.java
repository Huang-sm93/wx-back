package com.wx.appbackend.product.dao;

import com.wx.appbackend.product.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/22
 */
@Mapper
public interface OrderDao {

    OrderInfo get(long id) throws Exception;

    void update(OrderInfo orderInfo) throws Exception;
}
