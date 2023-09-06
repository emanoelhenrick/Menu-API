package com.emhk.menu.menuapi.domain.models;

import java.math.BigDecimal;
import java.util.*;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
  
  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private String name;

  private String description;

  @Column(nullable = false)
  private BigDecimal price;

  private String imageUrl;
  private String ingredients;

  @ManyToMany
  @JoinTable(
    name = "product_menu",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "menu_id")
  )
  private List<Menu> menu = new ArrayList<>();

  @ManyToOne
  private Establishment establishment;

}
