package com.emhk.menu.menuapi.data.services.order;

import java.util.List;
import java.util.UUID;

import com.emhk.menu.menuapi.domain.exceptions.order.OrderNotFoundException;
import com.emhk.menu.menuapi.domain.models.ProductOrder;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.models.Order;
import com.emhk.menu.menuapi.domain.repository.OrderRepository;
import com.emhk.menu.menuapi.domain.services.order.AddProductsToOrder;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DbAddProductsToOrder implements AddProductsToOrder {

  private final OrderRepository orderRepository;

  DbAddProductsToOrder(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public Order add(String orderUUID, List<ProductOrder> products) {
    var order = orderRepository
      .findById(UUID.fromString(orderUUID))
      .orElseThrow(() -> new OrderNotFoundException(orderUUID));
    products.forEach(product -> order.getProducts().add(product));
    return orderRepository.save(order);
  }
  
}
