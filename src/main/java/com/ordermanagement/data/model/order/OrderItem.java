package com.ordermanagement.data.model.order;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "orderItem")
public class OrderItem {

    @Id
    private int id;
    private int orderId;
    private int productId;
    private int quantity;
    private BigDecimal pricePerItem;


}
