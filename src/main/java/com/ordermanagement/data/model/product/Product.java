package com.ordermanagement.data.model.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    private int id;
    private String name;
    private BigDecimal price;
    private String businessId;
    private String description;
    private String createdDate;
    private String modifiedDate;
}
