package com.emhk.menu.menuapi.domain.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface Establishment {
  private UUID Id;
  private String name;
  private Address address;
  private OffsetDateTime createdAt;
  private OffsetDateTime updatedAt;
  private List<Menu> menus;
  private List<Product> products;
  private BigDecimal freightRate;
  private List<Order> orders;
  private List<FormOfPayment> formsOfPayment;
  private User owner;
}
