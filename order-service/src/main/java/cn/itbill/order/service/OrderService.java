package cn.itbill.order.service;

import cn.itbill.order.mapper.OrderMapper;
import cn.itbill.order.pojo.Order;
import cn.itbill.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1. 查询订单
        Order order = orderMapper.findById(orderId);
        // 2. 利用RestTemplate发送http请求
        String url = "http://userservice/user/" + order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        // 3. 封装并返回
        order.setUser(user);
        return order;
    }

//    @Autowired
//    private UserClient userClient;

//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//        // 2.用Feign远程调用
//        User user = userClient.findById(order.getUserId());
//        // 3.封装user到Order
//        order.setUser(user);
//        // 4.返回
//        return order;
//    }

    /*@Autowired
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.利用RestTemplate发起http请求，查询用户
        // 2.1.url路径
        String url = "http://userservice/user/" + order.getUserId();
        // 2.2.发送http请求，实现远程调用
        User user = restTemplate.getForObject(url, User.class);
        // 3.封装user到Order
        order.setUser(user);
        // 4.返回
        return order;
    }*/


}
