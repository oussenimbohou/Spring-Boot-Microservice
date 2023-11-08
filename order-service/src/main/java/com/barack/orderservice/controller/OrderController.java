package com.barack.orderservice.controller;
import com.barack.orderservice.common.TransactionRequest;
import com.barack.orderservice.common.TransactionResponse;
import com.barack.orderservice.entity.Order;
import com.barack.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){
        return orderService.saveOrder(request);
    }
    @GetMapping
    public List<Order> getOrder(){
        return  orderService.getOrder();
    }
}
