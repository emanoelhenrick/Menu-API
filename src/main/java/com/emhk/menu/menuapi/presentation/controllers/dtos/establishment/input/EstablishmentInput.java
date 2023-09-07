package com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.input;

import com.emhk.menu.menuapi.presentation.controllers.dtos.address.AddressInput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.user.input.UserIdInput;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EstablishmentInput {

	@NotBlank
	private UserIdInput owner;

	@NotBlank
	private String name;

	@Valid
	private AddressInput address;

}
