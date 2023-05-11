package com.ordermanagement.service.product;

import com.ordermanagement.data.model.business.Business;
import com.ordermanagement.service.dto.RegisterBusinessDTO;
import com.ordermanagement.web.exception.OrderManagementException;

import java.util.List;

public interface ProductService {

    void createProduct(RegisterBusinessDTO dto);
    Business findProductById(int businessId) throws OrderManagementException;
    List<Business> findAllProducts();
}
