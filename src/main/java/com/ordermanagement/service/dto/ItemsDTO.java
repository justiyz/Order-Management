package com.ordermanagement.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemsDTO {
    private int productId;
    private int quantity;
    private BigDecimal pricePerItem;
}
