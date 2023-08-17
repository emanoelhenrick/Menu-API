package com.emhk.menu.menuapi.domain.models;

import jakarta.persistence.Entity;
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

  private String name;
  private String description;
}
