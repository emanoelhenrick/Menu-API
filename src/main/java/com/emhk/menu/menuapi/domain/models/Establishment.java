package com.emhk.menu.menuapi.domain.models;

import java.time.OffsetDateTime;
import java.util.*;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Establishment {
  
  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID Id;

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

  @OneToMany(mappedBy = "establishment", fetch = FetchType.LAZY)
  private List<Product> products = new ArrayList<>();

  @OneToMany(mappedBy = "establishment", fetch = FetchType.LAZY)
  private List<Order> orders = new ArrayList<>();

  @OneToMany(mappedBy = "establishment", fetch = FetchType.LAZY)
  private List<EstablishmentTable> establishmentTables = new ArrayList<>();

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
    name = "establishment_forms_of_payment",
    joinColumns = @JoinColumn(name = "establishment_id"),
    inverseJoinColumns = @JoinColumn(name = "form_of_payment_id")
  )
  private List<FormOfPayment> formsOfPayment = new ArrayList<>();

  @ManyToOne
  private User owner;

}
