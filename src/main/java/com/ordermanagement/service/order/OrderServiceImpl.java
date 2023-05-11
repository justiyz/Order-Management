package com.ordermanagement.service.order;

import com.ordermanagement.data.model.order.Item;
import com.ordermanagement.data.model.order.Order;
import com.ordermanagement.data.repository.order.OrderRepository;
import com.ordermanagement.service.dto.PlaceOrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void placeOrder(PlaceOrderDTO dto) {
        Order order = new Order();
        Item item = new Item();
    }
}
