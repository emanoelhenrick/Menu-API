package com.emhk.menu.menuapi.domain.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface Product {
  private UUID id;
  private String name;
  private String description;
  private BigDecimal price;
  private String imageUrl;
  private String ingredients;
  private List<Menu> menu;
  private Establishment establishment;
}
