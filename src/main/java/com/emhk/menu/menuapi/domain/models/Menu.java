package com.emhk.menu.menuapi.domain.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface Menu {
  private UUID id;
  private String name;
  private List<Product> products;
  private Establishment establishment;
  private Boolean active;
}
