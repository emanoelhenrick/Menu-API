package com.emhk.menu.menuapi.domain.models;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
  
  private Long id;
  private String name;
  private String description;
  private BigDecimal price;
  private ProductCategory category;
  private String imageUrl;
  private String ingredients;

  private Menu menu;
  private Establishment establishment;

}
