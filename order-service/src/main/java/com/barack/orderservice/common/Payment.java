package com.barack.orderservice.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue
    private int paymentID;
    private String paymentStatus;
    private String transactionID;
    private double amount;
    private int orderId;
}
