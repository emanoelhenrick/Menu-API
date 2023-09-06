package com.emhk.menu.menuapi.presentation.controllers.dtos.product.input;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductInput {

  @NotBlank
  private String name;

  private String description;

  @PositiveOrZero
  private BigDecimal price;

  private String imageUrl;

  @NotBlank
  private String ingredients;

}
