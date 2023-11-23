package com.lopo.service.impl;

import com.lopo.domain.Order;
import com.lopo.domain.User;
import com.lopo.mapper.OrderMapper;
import com.lopo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderMapper orderMapper;
    private RestTemplate restTemplate;

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Order getById(Integer orderId) {
        Order order = orderMapper.selectById(orderId);
        // 使用服务名称小写代替服务地址和端口
        String url = "http://userservice/user/" + order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        order.setUser(user);
        return order;
    }
}
