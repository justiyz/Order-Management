package com.ordermanagement.service.product;

import com.ordermanagement.data.model.business.Business;
import com.ordermanagement.service.dto.RegisterBusinessDTO;
import com.ordermanagement.web.exception.OrderManagementException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Override
    public void createProduct(RegisterBusinessDTO dto) {

    }

    @Override
    public Business findProductById(int businessId) throws OrderManagementException {
        return null;
    }

    @Override
    public List<Business> findAllProducts() {
        return null;
    }
}
