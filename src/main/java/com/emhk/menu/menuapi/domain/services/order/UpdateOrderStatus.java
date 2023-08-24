package com.emhk.menu.menuapi.domain.services.order;

import com.emhk.menu.menuapi.domain.models.OrderStatus;

public interface UpdateOrderStatus {
  public void update(String orderUUID, OrderStatus status);
}
