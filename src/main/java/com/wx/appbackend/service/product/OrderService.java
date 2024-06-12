package com.wx.appbackend.service.product;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/10/11
 */
public interface OrderService {
    public int createOrderSync();

    public int createOrder();

    int getOrderSize();
}
