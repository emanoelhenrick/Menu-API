package com.emhk.menu.menuapi.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
  
  @Column(name = "address_cep", nullable = false)
  private String cep;

  @Column(name = "address_district", nullable = false)
  private String district;

  @Column(name = "address_number", nullable = false)
  private String number;

  @Column(name = "address_city", nullable = false)
  private String city;

  @Column(name = "address_state", nullable = false)
  private String State;

  @Column(name = "address_complement")
  private String complement;

}
