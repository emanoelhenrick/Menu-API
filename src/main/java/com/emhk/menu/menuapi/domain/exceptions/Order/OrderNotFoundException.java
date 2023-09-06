package com.emhk.menu.menuapi.domain.exceptions.Order;

import com.emhk.menu.menuapi.domain.exceptions.EntityNotFoundException;

import java.util.UUID;

public class OrderNotFoundException extends EntityNotFoundException {

	public OrderNotFoundException(String reason) {
		super(reason);
	}

	public OrderNotFoundException(UUID id) {
		super("there is no Order with id " + id);
	}

}
