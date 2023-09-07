package com.emhk.menu.menuapi.presentation.controllers.dtos.product.output;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductOrderOutput {

	private String productId;
	private BigDecimal unitPrice;
	private Integer quantity;

}
