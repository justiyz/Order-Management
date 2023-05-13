package com.ordermanagement.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemsDto {
    private int productId;
    private int quantity;
    private BigDecimal pricePerItem;
}
