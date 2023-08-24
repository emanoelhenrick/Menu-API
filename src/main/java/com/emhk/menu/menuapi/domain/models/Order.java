package com.emhk.menu.menuapi.domain.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "orders")
public class Order {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include  
  private Long id;

  private UUID externalId;

  @ManyToOne
  private User user;

  @ManyToOne
  private Establishment establishment;

  private BigDecimal totalPrice;
  private List<Product> products;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  @CreationTimestamp
  @Column(columnDefinition = "timestamp")
  private OffsetDateTime createdAt;

  @UpdateTimestamp
  @Column(columnDefinition = "timestamp")
  private OffsetDateTime updatedAt;

  public void calcTotalPrice() {
    BigDecimal total = new BigDecimal(0);
    products.forEach(product -> total.add(product.getPrice()));
    total.subtract(establishment.getFreightRate());
    this.totalPrice = total;
  }

  @PrePersist
  private void generateUUID() {
    this.externalId = UUID.randomUUID();
  }

}
