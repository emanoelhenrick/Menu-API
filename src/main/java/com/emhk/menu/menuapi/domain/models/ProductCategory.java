package com.emhk.menu.menuapi.domain.models;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ProductCategory {
  
  private Long id;
  private String name;
  private String description;

  private List<Product> products;

}
