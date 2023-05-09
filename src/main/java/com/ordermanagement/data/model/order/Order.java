package com.ordermanagement.data.model.order;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "order")
public class Order {

    @Id
    private int id;
    private String status;
    private String orderNumber;
    private BigDecimal totalAmount;
    @OneToMany
    private List<OrderItem> orderItems;
}
