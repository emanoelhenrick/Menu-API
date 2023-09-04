package com.emhk.menu.menuapi.data.services.order;

import java.util.UUID;

import com.emhk.menu.menuapi.domain.exceptions.Order.OrderNotFoundException;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.models.OrderStatus;
import com.emhk.menu.menuapi.domain.repository.OrderRepository;
import com.emhk.menu.menuapi.domain.services.order.UpdateOrderStatus;

@Service
public class DbUpdateOrderStatus implements UpdateOrderStatus {

  private final OrderRepository orderRepository;

  DbUpdateOrderStatus(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public void update(String orderUUID, OrderStatus status) {
    var order = orderRepository
      .findById(UUID.fromString(orderUUID))
      .orElseThrow(() -> new OrderNotFoundException(orderUUID));
    order.setStatus(status);
    orderRepository.save(order);
  }
  
}
