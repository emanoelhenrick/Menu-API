package com.emhk.menu.menuapi.data.services.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.models.OrderStatus;
import com.emhk.menu.menuapi.domain.repository.OrderRepository;
import com.emhk.menu.menuapi.domain.services.order.UpdateOrderStatus;

@Service
public class DbUpdateOrderStatus implements UpdateOrderStatus {

  @Autowired
  private OrderRepository repository;

  @Override
  public void update(String orderUUID, OrderStatus status) {
    var order = repository.findByExternalId(orderUUID);
    order.setStatus(status);
    repository.save(order);
  }
  
}
