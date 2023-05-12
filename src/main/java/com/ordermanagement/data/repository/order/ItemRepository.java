package com.ordermanagement.data.repository.order;

import com.ordermanagement.data.model.order.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
