package com.emhk.menu.menuapi.data.services.order;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.models.Order;
import com.emhk.menu.menuapi.domain.models.Product;
import com.emhk.menu.menuapi.domain.repository.OrderRepository;
import com.emhk.menu.menuapi.domain.services.order.AddProductsToOrder;

@Service
public class DbAddProductsToOrder implements AddProductsToOrder {

  @Autowired
  private OrderRepository repository;

  @Override
  public Order add(String orderUUID, List<Product> products) {
    var order = repository.findById(orderUUID).orElseThrow();
    products.forEach(product -> order.getProducts().add(product));
    return repository.save(order);
  }
  
}
