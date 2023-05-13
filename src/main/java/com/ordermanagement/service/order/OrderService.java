package com.ordermanagement.service.order;

import com.ordermanagement.service.dto.PlaceOrderDto;
import com.ordermanagement.web.exception.OrderManagementException;

public interface OrderService {
    void placeOrder(PlaceOrderDto dto) throws OrderManagementException;
}
