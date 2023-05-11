package com.ordermanagement.web.controller.product;


import com.ordermanagement.data.model.business.Business;
import com.ordermanagement.data.model.product.Product;
import com.ordermanagement.service.business.BusinessServiceImpl;
import com.ordermanagement.service.dto.CreateProductDTO;
import com.ordermanagement.service.dto.RegisterBusinessDTO;
import com.ordermanagement.service.dto.response.BusinessResponse;
import com.ordermanagement.service.dto.response.ProductResponse;
import com.ordermanagement.service.product.ProductServiceImpl;
import com.ordermanagement.web.exception.OrderManagementException;
import com.ordermanagement.web.response.ResponseDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody CreateProductDTO dto) throws OrderManagementException {
        productServiceImpl.createProduct(dto);
        ResponseDetails responseDetails = new ResponseDetails(LocalDateTime.now(), "Your product has been created successfully", HttpStatus.OK.toString());
        return new ResponseEntity<>(responseDetails, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable int id) throws OrderManagementException {
        Product product = productServiceImpl.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllProducts(@RequestParam(defaultValue = "1") int page,
                                             @RequestParam(defaultValue = "1") int limit) {
        ProductResponse response = productServiceImpl.findAllProducts(page, limit);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
