package com.ordermanagement.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductDto {
    private String name;
    private BigDecimal price;
    private int businessId;
    private String description;
}
