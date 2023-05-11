package com.ordermanagement.service.order;

import com.ordermanagement.service.dto.PlaceOrderDTO;

public interface OrderService {
    void placeOrder(PlaceOrderDTO dto);
}
