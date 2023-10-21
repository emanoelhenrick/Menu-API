package com.emhk.menu.menuapi.domain.services.order;

import com.emhk.menu.menuapi.domain.models.Order;
import com.emhk.menu.menuapi.domain.models.OrderStatus;

import java.util.List;

public interface OrderQueue {
  List<Order> getAllOrdersByStatus(String id, OrderStatus status);
}
