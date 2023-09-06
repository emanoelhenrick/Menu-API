package com.emhk.menu.menuapi.presentation.controllers.dtos.product.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOrderInput {

	private ProductIdInput product;
	private Integer quantity;

}
