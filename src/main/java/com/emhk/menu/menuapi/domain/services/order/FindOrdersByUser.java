package com.emhk.menu.menuapi.domain.services.order;

import com.emhk.menu.menuapi.domain.models.Order;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FindOrdersByUser {
  List<Order> find(String username, Pageable pageable);
}
