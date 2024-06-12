package com.wx.appbackend.service.product;

import com.wx.appbackend.common.ServiceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/10/11
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    //注入RedissonClient
    @Autowired
    OrderService orderService;

    @GetMapping("/orderSync")
    public ServiceData<String> orderSync()throws Exception{
        ServiceData sd = new ServiceData();
//        orderService.createOrderSync();
        sd.setBo("success");
        return sd;
    }

    @GetMapping("/order")
    public ServiceData<String> order()throws Exception{
        ServiceData sd = new ServiceData();
        orderService.createOrder();
        sd.setBo("success");
        return sd;
    }

    @GetMapping("/getOrderSize")
    public ServiceData<String> getOrderSize()throws Exception{
        ServiceData sd = new ServiceData();
        sd.setBo(orderService.getOrderSize());
        return sd;
    }


}
