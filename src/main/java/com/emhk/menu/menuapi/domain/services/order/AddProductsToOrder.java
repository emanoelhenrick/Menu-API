package com.emhk.menu.menuapi.domain.services.order;

import java.util.List;

import com.emhk.menu.menuapi.domain.models.Order;
import com.emhk.menu.menuapi.domain.models.Product;

public interface AddProductsToOrder {
  public Order add(Long OrderId, List<Product> products);
}
