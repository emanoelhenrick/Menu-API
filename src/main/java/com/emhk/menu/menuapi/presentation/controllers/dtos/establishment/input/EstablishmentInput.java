package com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.input;

import com.emhk.menu.menuapi.presentation.controllers.dtos.address.AddressInput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.user.input.UserUsernameInput;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstablishmentInput {

	@Valid
	private UserUsernameInput owner;

	@NotBlank
	private String name;

	@Valid
	private AddressInput address;

}
