package com.emhk.menu.menuapi.domain.services.order;

import java.util.List;

import com.emhk.menu.menuapi.domain.models.Order;
import com.emhk.menu.menuapi.domain.models.Product;
import com.emhk.menu.menuapi.domain.models.ProductOrder;

public interface AddProductsToOrder {
  public Order add(String orderId, List<ProductOrder> products);
}
