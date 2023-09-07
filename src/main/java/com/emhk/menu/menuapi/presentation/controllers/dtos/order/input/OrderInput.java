package com.emhk.menu.menuapi.presentation.controllers.dtos.order.input;

import com.emhk.menu.menuapi.presentation.controllers.dtos.product.input.ProductOrderInput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.user.input.UserUsernameInput;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderInput {

	@Valid
	private UserUsernameInput customer;

	@NotNull
	private List<ProductOrderInput> products;

}
