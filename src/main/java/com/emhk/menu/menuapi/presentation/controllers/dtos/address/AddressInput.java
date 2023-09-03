package com.emhk.menu.menuapi.presentation.controllers.dtos.address;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressInput {

  @NotBlank
  private String cep;

  @NotBlank
  private String district;

  @NotBlank
  private String number;

  @NotBlank
  private String city;

  @NotBlank
  private String State;

  @NotBlank
  private String complement;

}
