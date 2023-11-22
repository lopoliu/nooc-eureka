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
        String url = "http://userService:8082/user/" + order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        order.setUser(user);
        return order;
    }
}
