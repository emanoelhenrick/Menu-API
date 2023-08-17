package com.emhk.menu.menuapi.domain.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Establishment {
  
  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Embedded
  @Column(nullable = false)
  private Address address;

  @CreationTimestamp
  @Column(columnDefinition = "datetime")
  private OffsetDateTime createdAt;

  @UpdateTimestamp
  @Column(columnDefinition = "datetime")
  private OffsetDateTime updatedAt;

  private Menu menu;
  
  @Column(nullable = false)
  private BigDecimal freightRate;

  
  private List<FormOfPayment> formsOfPayment;

}
