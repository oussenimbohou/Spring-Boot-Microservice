package com.barack.paymentservice.service;

import com.barack.paymentservice.entity.Payment;
import com.barack.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment){
        payment.setTransactionID(UUID.randomUUID().toString());
        payment.setPaymentStatus(paymentProcessing());
        System.out.println("payment = " + payment);
        return  paymentRepository.save(payment);
    }

    public List<Payment> getPayment(){
        return paymentRepository.findAll();
    }
    public String paymentProcessing(){
        return new Random().nextBoolean() ? "true" : "false";
    }

    public Payment getPaymentByOrderId(int orderId) {
        return paymentRepository.findByOrderId(orderId);
    }
}
