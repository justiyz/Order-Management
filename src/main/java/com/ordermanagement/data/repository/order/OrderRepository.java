package com.ordermanagement.data.repository.order;

import com.ordermanagement.data.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
