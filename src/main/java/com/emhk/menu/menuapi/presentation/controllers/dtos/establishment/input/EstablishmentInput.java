package com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.input;

import com.emhk.menu.menuapi.presentation.controllers.dtos.address.AddressInput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.user.input.UserIdInput;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EstablishmentInput {

	private UserIdInput owner;
	private String name;
	private AddressInput address;

}
