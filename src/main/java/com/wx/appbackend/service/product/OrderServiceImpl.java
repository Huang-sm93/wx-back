package com.wx.appbackend.service.product;

import com.wx.appbackend.service.product.dao.OrderDao;
import com.wx.appbackend.service.product.entity.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/10/11
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;

    @Override
    public int createOrderSync() {
        int result = 0;
//        RLock lock = redissonClient.getLock(RedisKeyUtility.ORDER_KEY);
//        try {
//            lock.lock(10, TimeUnit.SECONDS);
//            OrderInfo orderInfo = orderDao.get(1);
//            if (orderInfo != null) {
//                orderInfo.count--;
//                orderDao.update(orderInfo);
//                result = 1;
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }finally {
//            lock.unlock();
//        }

        return result;
    }

    @Override
    public int createOrder() {
        int result = 0;
        try {
            OrderInfo orderInfo = orderDao.get(1);
            if (orderInfo != null) {
                orderInfo.count--;
                orderDao.update(orderInfo);
                result = 1;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public int getOrderSize() {
        int result = 0;
        try {
            OrderInfo orderInfo = orderDao.get(1);
            if (orderInfo != null) {
                result = orderInfo.count;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
