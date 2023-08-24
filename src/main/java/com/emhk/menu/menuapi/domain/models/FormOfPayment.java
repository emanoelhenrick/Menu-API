package com.emhk.menu.menuapi.domain.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class FormOfPayment {
  
  @Id
  @EqualsAndHashCode.Include
  private Long id;

  @Column(unique = true)
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID externalId;

  private String name;
  private String description;

}
