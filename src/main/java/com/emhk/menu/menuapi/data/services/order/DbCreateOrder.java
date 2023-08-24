package com.emhk.menu.menuapi.data.services.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.models.Order;
import com.emhk.menu.menuapi.domain.repository.OrderRepository;
import com.emhk.menu.menuapi.domain.services.order.CreateOrder;

@Service
public class DbCreateOrder implements CreateOrder {

  @Autowired
  private OrderRepository repository;

  @Override
  public Order create(Order order) {
    return repository.save(order);
  }
  
}
