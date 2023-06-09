package com.ordermanagement.service.product;

import com.ordermanagement.data.model.product.Product;
import com.ordermanagement.data.repository.business.BusinessRepository;
import com.ordermanagement.data.repository.product.ProductRepository;
import com.ordermanagement.service.dto.CreateProductDto;
import com.ordermanagement.service.dto.response.ProductResponse;
import com.ordermanagement.web.exception.OrderManagementException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
    public void createProduct(CreateProductDto dto) throws OrderManagementException {
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
        return productRepository.findById(businessId)
                .orElseThrow(() -> new OrderManagementException("Product not found"));
    }

    @Override
    public ProductResponse findAllProducts(int pageNumber, int pageSize) {
        ProductResponse response = new ProductResponse();
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<Product> pagedResult = productRepository.findAll(pageable);
        response.setNoOfTotalProducts(pagedResult.toList().size());
        response.setNoOfTotalPages(pagedResult.getTotalPages());
        response.setTotalProducts(pagedResult.toList());
        response.setCurrentPage(pageNumber);
        response.setPageSize(pageSize);
        return response;
    }
}
