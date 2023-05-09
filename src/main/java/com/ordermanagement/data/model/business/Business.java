package com.ordermanagement.data.model.business;

import com.ordermanagement.data.model.order.Order;
import com.ordermanagement.data.model.product.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "business")
public class Business {

    @Id
    private int id;
    private String name;
    private String email;
    private String location;
    private String description;
    private String phoneNumber;
    @OneToMany
    private List<Product> products;
    private String createdDate;
    private String modifiedDate;

}
