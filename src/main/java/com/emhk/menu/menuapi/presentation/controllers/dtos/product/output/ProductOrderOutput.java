package com.emhk.menu.menuapi.presentation.controllers.dtos.product.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOrderOutput {

	private ProductShortOutput product;
	private Integer quantity;

}
