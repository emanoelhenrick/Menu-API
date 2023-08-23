package com.emhk.menu.menuapi.presentation.dtos.product.output;

import java.math.BigDecimal;

import com.emhk.menu.menuapi.presentation.dtos.establishment.output.EstablishmentShortOutput;
import com.emhk.menu.menuapi.presentation.dtos.menu.output.MenuShortOutput;
import com.emhk.menu.menuapi.presentation.dtos.productCategory.output.ProductCategoryShortOutput;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOutput {

  private Long id;
  private String name;
  private String description;
  private BigDecimal price;
  private ProductCategoryShortOutput category;
  private String imageUrl;
  private String ingredients;
  private MenuShortOutput menu;
  private EstablishmentShortOutput establishment;
  
}
