package com.emhk.menu.menuapi.domain.exceptions.order;

import com.emhk.menu.menuapi.domain.exceptions.EntityNotFoundException;

public class OrderNotFoundException extends EntityNotFoundException {

	public OrderNotFoundException(String id) {
		super("there is no Order with id " + id);
	}

}
