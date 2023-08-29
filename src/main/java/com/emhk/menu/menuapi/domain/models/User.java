package com.emhk.menu.menuapi.domain.models;

import java.util.List;
import java.util.UUID;

public interface User {
  private UUID id;
  private String name;
  private String username;
  private String email;
  private String password;
  private UserRole role;
  private List<Establishment> establishments;
  private List<Order> orders;
}
