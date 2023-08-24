package com.emhk.menu.menuapi.presentation.dtos.establishment.input;

import java.math.BigDecimal;

import com.emhk.menu.menuapi.presentation.dtos.address.AddressInput;
import com.emhk.menu.menuapi.presentation.dtos.user.input.UserIdInput;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstablishmentInput {

  @NotBlank
  private String name;

  @NotNull
  private UserIdInput owner;

  @Valid
  private AddressInput address;
  private BigDecimal freightRate;

}
