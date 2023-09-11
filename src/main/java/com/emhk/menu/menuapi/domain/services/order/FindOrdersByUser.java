package com.emhk.menu.menuapi.domain.services.order;

import com.emhk.menu.menuapi.domain.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindOrdersByUser {
  Page<Order> find(String username, Pageable pageable);
}
