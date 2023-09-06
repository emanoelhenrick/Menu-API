package com.emhk.menu.menuapi.presentation.controllers.dtos.order.input;

import com.emhk.menu.menuapi.presentation.controllers.dtos.product.input.ProductOrderInput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.user.input.UserIdInput;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderInput {

	private UserIdInput customer;
	private List<ProductOrderInput> products;

}
