package com.ordermanagement.data.model.business;

import com.ordermanagement.data.model.order.Order;
import com.ordermanagement.data.model.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "business")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
