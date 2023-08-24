package com.emhk.menu.menuapi.presentation.dtos.product.output;

import java.math.BigDecimal;

import com.emhk.menu.menuapi.presentation.dtos.establishment.output.EstablishmentShortOutput;
import com.emhk.menu.menuapi.presentation.dtos.menu.output.MenuShortOutput;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOutput {

  private String id;
  private String name;
  private String description;
  private BigDecimal price;
  private String imageUrl;
  private String ingredients;
  private MenuShortOutput menu;
  private EstablishmentShortOutput establishment;
  
}
