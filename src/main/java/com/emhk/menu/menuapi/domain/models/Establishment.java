package com.emhk.menu.menuapi.domain.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
  @Column(columnDefinition = "timestamp")
  private OffsetDateTime createdAt;

  @UpdateTimestamp
  @Column(columnDefinition = "timestamp")
  private OffsetDateTime updatedAt;

  @OneToMany(mappedBy = "establishment")
  private List<Menu> menus = new ArrayList<>();

  @OneToMany(mappedBy = "establishment")
  private List<Product> products;
  
  @Column(nullable = false)
  private BigDecimal freightRate;

  @ManyToMany
  @JoinTable(
    name = "establishment_forms_of_payment",
    joinColumns = @JoinColumn(name = "establishment_id"),
    inverseJoinColumns = @JoinColumn(name = "form_of_payment_id")
  )
  private List<FormOfPayment> formsOfPayment = new ArrayList<>();

  @ManyToOne
  private User owner;

}
