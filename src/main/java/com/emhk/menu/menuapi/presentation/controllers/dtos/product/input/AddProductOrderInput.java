package com.emhk.menu.menuapi.presentation.controllers.dtos.product.input;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddProductOrderInput {

  @Valid
  List<ProductOrderInput> products;

}
