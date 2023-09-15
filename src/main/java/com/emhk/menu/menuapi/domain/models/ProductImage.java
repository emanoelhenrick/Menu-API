package com.emhk.menu.menuapi.domain.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductImage {
  @Id
  @Column(name = "product_id")
  @EqualsAndHashCode.Include
  private UUID id;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  private Product product;

  private String fileName;

  private String contentType;

  private Long fileSize;

}
