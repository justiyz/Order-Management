package com.ordermanagement.service.product;

import com.ordermanagement.data.model.business.Business;
import com.ordermanagement.data.model.product.Product;
import com.ordermanagement.service.dto.CreateProductDTO;
import com.ordermanagement.service.dto.RegisterBusinessDTO;
import com.ordermanagement.service.dto.response.ProductResponse;
import com.ordermanagement.web.exception.OrderManagementException;

import java.util.List;

public interface ProductService {

    void createProduct(CreateProductDTO dto) throws OrderManagementException;
    Product findProductById(int businessId) throws OrderManagementException;
    ProductResponse findAllProducts(int pageNumber, int pageSIze);
}
