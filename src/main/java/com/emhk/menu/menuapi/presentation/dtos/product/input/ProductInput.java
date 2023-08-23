package com.emhk.menu.menuapi.presentation.dtos.product.input;

import java.math.BigDecimal;

import com.emhk.menu.menuapi.presentation.dtos.productCategory.input.ProductCategoryInput;

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

  private ProductCategoryInput category;
  private String imageUrl;

  @NotBlank
  private String ingredients;

  @NotNull
  private Long establishmentId;

}
