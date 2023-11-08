package com.barack.orderservice.repository;

import com.barack.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositiory extends JpaRepository<Order, Integer> {
}
