package com.ordermanagement.data.model.order;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String orderNumber;
    private BigDecimal totalAmount;
    @OneToMany
    private List<Item> items;
    @Enumerated
    private OrderStatus orderStatus;
    private String customerPhoneNumber;
    private String createdDate;
    private String modifiedDate;
}
