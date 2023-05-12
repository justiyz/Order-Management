package com.ordermanagement.service.order;

import com.ordermanagement.data.model.order.Item;
import com.ordermanagement.data.model.order.Order;
import com.ordermanagement.data.model.order.OrderStatus;
import com.ordermanagement.data.repository.order.OrderRepository;
import com.ordermanagement.service.dto.PlaceOrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void placeOrder(PlaceOrderDTO dto) {
        Order order = new Order();
        order.setOrderNumber(generateOrderNumber(8));
        order.setOrderStatus(OrderStatus.PROCESSING);
        orderRepository.save(order);
        Item item = new Item();
    }

    private String generateOrderNumber(int length){
        return UUID.randomUUID().toString().replace("-", "").substring(0, length);
    }
}
