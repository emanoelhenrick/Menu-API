package com.emhk.menu.menuapi.domain.services.order;

import com.emhk.menu.menuapi.domain.models.Order;

import java.util.List;

public interface FindOrdersByUser {
  List<Order> find(String username);
}
