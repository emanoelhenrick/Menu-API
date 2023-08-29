package com.emhk.menu.menuapi.domain.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public interface Order {
  private UUID id;
  private User user;
  private Establishment establishment;
  private BigDecimal totalPrice;
  private List<Product> products;
  private OrderStatus status;
  private OffsetDateTime createdAt;
  private OffsetDateTime updatedAt;
  
  public void calcTotalPrice();
}
