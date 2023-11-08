package com.barack.orderservice.service;

import com.barack.orderservice.common.Payment;
import com.barack.orderservice.common.TransactionRequest;
import com.barack.orderservice.common.TransactionResponse;
import com.barack.orderservice.entity.Order;
import com.barack.orderservice.repository.OrderRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepositiory orderRepositiory;
    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest request){
        String message;
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        Payment paymentResponse = restTemplate.postForObject(
                "http://localhost:9191/payments/doPayment",
                payment, Payment.class);
        assert paymentResponse != null;
        System.out.println("paymentResponse = " + paymentResponse);
        message = paymentResponse.getPaymentStatus().equals("true") ? "Payment processing successful" : "Failure occurred...";
          orderRepositiory.save(order);
          return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionID(), message);
    }
   public  List<Order> getOrder(){
        return orderRepositiory.findAll();
    }
}
