package com.emhk.menu.menuapi.domain.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.*;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "orders")
public class Order {
  
  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(nullable = false)
  private User customer;

  private int tableNumber;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Establishment establishment;

  private BigDecimal totalPrice = BigDecimal.ZERO;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
    name = "order_product_order",
    joinColumns = @JoinColumn(name = "order_id"),
    inverseJoinColumns = @JoinColumn(name = "productOrder_id")
  )
  private List<ProductOrder> products = new ArrayList<>();

  @Enumerated(EnumType.STRING)
  private OrderStatus status = OrderStatus.CREATED;

  @CreationTimestamp
  @Column(columnDefinition = "timestamp")
  private OffsetDateTime createdAt;

  @UpdateTimestamp
  @Column(columnDefinition = "timestamp")
  private OffsetDateTime updatedAt;

}
