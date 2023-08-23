package com.emhk.menu.menuapi.presentation.dtos.productCategory.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCategoryInput {

  @NotBlank
  private String name;
  private String description;

}
