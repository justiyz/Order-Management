package com.ordermanagement.service.product;

import com.ordermanagement.data.model.product.Product;
import com.ordermanagement.service.dto.CreateProductDto;
import com.ordermanagement.service.dto.response.ProductResponse;
import com.ordermanagement.web.exception.OrderManagementException;

public interface ProductService {

    void createProduct(CreateProductDto dto) throws OrderManagementException;
    Product findProductById(int businessId) throws OrderManagementException;
    ProductResponse findAllProducts(int pageNumber, int pageSIze);
}
