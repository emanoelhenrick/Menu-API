package com.emhk.menu.menuapi.data.services.order;

import com.emhk.menu.menuapi.domain.exceptions.establishment.EstablishmentNotFoundException;
import com.emhk.menu.menuapi.domain.models.Order;
import com.emhk.menu.menuapi.domain.models.OrderStatus;
import com.emhk.menu.menuapi.domain.repository.EstablishmentRepository;
import com.emhk.menu.menuapi.domain.repository.OrderRepository;
import com.emhk.menu.menuapi.domain.services.order.OrderQueue;

import java.util.List;
import java.util.UUID;

public class DbOrderQueue implements OrderQueue {

  private final OrderRepository orderRepository;

  private final EstablishmentRepository establishmentRepository;

  DbOrderQueue(OrderRepository orderRepository, EstablishmentRepository establishmentRepository) {
    this.orderRepository = orderRepository;
    this.establishmentRepository = establishmentRepository;
  }

  @Override
  public List<Order> getAllOrdersByStatus(String id, OrderStatus status) {
    establishmentRepository.findById(UUID.fromString(id))
      .orElseThrow(() -> new EstablishmentNotFoundException(id));
    return orderRepository.findAllbyStatus(UUID.fromString(id), status);
  }

}
