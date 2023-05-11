package com.ordermanagement.service.dto.response;

import com.ordermanagement.data.model.business.Business;
import com.ordermanagement.data.model.product.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductResponse {
    private List<Product> totalProducts;
    private long noOfTotalProducts;
    private Integer noOfTotalPages;
    private Integer currentPage;
    private Integer pageSize;
}
