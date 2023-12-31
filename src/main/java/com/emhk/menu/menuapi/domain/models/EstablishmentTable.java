package com.emhk.menu.menuapi.domain.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EstablishmentTable {

  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private int number;

  @ManyToOne
  private Establishment establishment;

  @Column(nullable = false)
  private Boolean isBusy = false;

  @Column(nullable = false)
  private Boolean active = true;

}
