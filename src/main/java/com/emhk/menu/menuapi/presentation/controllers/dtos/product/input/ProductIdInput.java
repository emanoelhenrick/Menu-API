package com.emhk.menu.menuapi.presentation.controllers.dtos.product.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductIdInput {

	@NotBlank
	private String id;

}
