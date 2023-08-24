package com.emhk.menu.menuapi.domain.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
  
  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID externalId;
  
  private String name;
  private String description;
  private BigDecimal price;

  private String imageUrl;
  private String ingredients;

  @ManyToMany
  @JoinTable(
    name = "product_menu",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "menu_id")
  )
  private List<Menu> menu;

  @ManyToOne
  private Establishment establishment;

}
