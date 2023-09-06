package com.emhk.menu.menuapi.presentation.controllers.dtos.product.output;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductShortOutput {
	private String id;
	private String name;
	private BigDecimal price;
}
