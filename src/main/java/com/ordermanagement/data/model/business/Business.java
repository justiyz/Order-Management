package com.ordermanagement.data.model.business;

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
    private String location;

    @OneToMany
    private List<Product> products;

}
