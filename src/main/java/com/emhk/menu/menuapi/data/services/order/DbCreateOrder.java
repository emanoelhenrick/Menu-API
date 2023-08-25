package com.emhk.menu.menuapi.data.services.order;

import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.models.Order;
import com.emhk.menu.menuapi.domain.repository.OrderRepository;
import com.emhk.menu.menuapi.domain.services.order.CreateOrder;

@Service
public class DbCreateOrder implements CreateOrder {

  private final OrderRepository orderRepository;

  DbCreateOrder(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public Order create(Order order) {
    return orderRepository.save(order);
  }
  
}
