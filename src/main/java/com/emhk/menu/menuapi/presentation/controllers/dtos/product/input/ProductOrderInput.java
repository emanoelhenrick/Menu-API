package com.emhk.menu.menuapi.presentation.controllers.dtos.product.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOrderInput {

	@NotBlank
	private ProductIdInput product;

	@Positive
	private Integer quantity;

}
