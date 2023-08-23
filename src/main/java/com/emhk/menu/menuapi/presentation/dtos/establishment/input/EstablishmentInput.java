package com.emhk.menu.menuapi.presentation.dtos.establishment.input;

import java.math.BigDecimal;

import com.emhk.menu.menuapi.presentation.dtos.address.AddressInput;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstablishmentInput {

  @NotBlank
  private String name;

  @Valid
  private AddressInput address;
  private BigDecimal freightRate;

}
