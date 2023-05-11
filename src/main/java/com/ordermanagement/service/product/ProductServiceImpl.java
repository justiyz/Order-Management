package com.ordermanagement.service.product;

import com.ordermanagement.data.model.business.Business;
import com.ordermanagement.data.model.product.Product;
import com.ordermanagement.data.repository.business.BusinessRepository;
import com.ordermanagement.data.repository.product.ProductRepository;
import com.ordermanagement.service.dto.CreateProductDTO;
import com.ordermanagement.service.dto.RegisterBusinessDTO;
import com.ordermanagement.web.exception.OrderManagementException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BusinessRepository businessRepository;

    @Override
    public void createProduct(CreateProductDTO dto) throws OrderManagementException {
        if (!businessRepository.existsById(dto.getBusinessId())) {
            throw new OrderManagementException("Business not found");
        }
        Product product = mapper.map(dto, Product.class);
        product.setCreatedDate(LocalDateTime.now().toString());
        product.setModifiedDate(LocalDateTime.now().toString());
        productRepository.save(product);
    }

    @Override
    public Product findProductById(int businessId) throws OrderManagementException {
        return null;
    }

    @Override
    public List<Product> findAllProducts() {
        return null;
    }
}
