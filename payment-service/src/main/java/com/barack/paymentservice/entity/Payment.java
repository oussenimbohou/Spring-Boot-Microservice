package com.barack.paymentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PAYMENT_TB")
public class Payment {

    @Id
    @GeneratedValue
    private int paymentID;
    private String paymentStatus;
    private String transactionID;
    private double amount;
    private int orderId;
}
