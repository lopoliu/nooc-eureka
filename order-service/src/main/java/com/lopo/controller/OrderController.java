package com.lopo.controller;


import com.lopo.domain.Order;
import com.lopo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;


    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public String create(){
        return "order create";
    }

    @GetMapping("/{orderId}")
    public Order detail(@PathVariable Integer orderId){
        return orderService.getById(orderId);
    }
}
