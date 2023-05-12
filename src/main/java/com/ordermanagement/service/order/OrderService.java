package com.ordermanagement.service.order;

import com.ordermanagement.service.dto.PlaceOrderDTO;
import com.ordermanagement.web.exception.OrderManagementException;

public interface OrderService {
    void placeOrder(PlaceOrderDTO dto) throws OrderManagementException;
}
