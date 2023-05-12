package com.ordermanagement.service.order;

import com.ordermanagement.data.model.order.Item;
import com.ordermanagement.data.model.order.Order;
import com.ordermanagement.data.model.order.OrderStatus;
import com.ordermanagement.data.model.product.Product;
import com.ordermanagement.data.repository.order.ItemRepository;
import com.ordermanagement.data.repository.order.OrderRepository;
import com.ordermanagement.data.repository.product.ProductRepository;
import com.ordermanagement.service.dto.ItemsDTO;
import com.ordermanagement.service.dto.PlaceOrderDTO;
import com.ordermanagement.web.exception.OrderManagementException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public void placeOrder(PlaceOrderDTO dto) throws OrderManagementException {
        Order order = new Order();
        order.setCustomerPhoneNumber(dto.getCustomerPhoneNumber());
        order.setOrderNumber(generateOrderNumber(8));
        order.setOrderStatus(OrderStatus.PROCESSING);
        orderRepository.save(order);

        Item item;
        Product product;
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (ItemsDTO itemsDTO: dto.getItems()){
            item = new Item();
            product = getProduct(itemsDTO.getProductId());

            item.setOrderId(order.getId());
            item.setProductId(product.getId());
            item.setPricePerItem(product.getPrice());
            item.setQuantity(itemsDTO.getQuantity());
            item.setSubTotal(product.getPrice().multiply
                    (BigDecimal.valueOf(itemsDTO.getQuantity())));
            item.setCreatedDate(LocalDateTime.now().toString());
            item.setModifiedDate(LocalDateTime.now().toString());
            itemRepository.save(item);

            totalAmount = totalAmount.add(item.getSubTotal());
        }
        order.setTotalAmount(totalAmount);
        order.setCreatedDate(LocalDateTime.now().toString());
        order.setModifiedDate(LocalDateTime.now().toString());
        orderRepository.save(order);
    }

    Product getProduct(int productId) throws OrderManagementException {
        return productRepository.findById(productId)
                .orElseThrow(()-> new OrderManagementException("Product not found"));
    }

    private String generateOrderNumber(int length){
        return UUID.randomUUID().toString().replace("-", "").substring(0, length);
    }
}
