package com.ordermanagement.web.controller.order;

import com.ordermanagement.service.dto.PlaceOrderDto;
import com.ordermanagement.service.order.OrderServiceImpl;
import com.ordermanagement.web.exception.OrderManagementException;
import com.ordermanagement.web.response.ResponseDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderServiceImpl orderServiceImpl;


    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody PlaceOrderDto dto) throws OrderManagementException {
        orderServiceImpl.placeOrder(dto);
        ResponseDetails responseDetails = new ResponseDetails(LocalDateTime.now(), "Your Order has been created successfully", HttpStatus.OK.toString());
        return new ResponseEntity<>(responseDetails, HttpStatus.OK);
    }
}
