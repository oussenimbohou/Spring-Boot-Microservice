package com.barack.paymentservice.controller;

import com.barack.paymentservice.entity.Payment;
import com.barack.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment){
        return paymentService.doPayment(payment);
    }
    @GetMapping
    public List<Payment> getPayment(){
        return  paymentService.getPayment();
    }
    @GetMapping("/{orderId}")
    public Payment getPaymentByOrderId(@PathVariable int orderId){
        return paymentService.getPaymentByOrderId(orderId);
    }

}
