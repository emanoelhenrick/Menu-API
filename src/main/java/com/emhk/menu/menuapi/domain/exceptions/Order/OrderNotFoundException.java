package com.emhk.menu.menuapi.domain.exceptions.Order;

public class OrderNotFoundException extends RuntimeException {

	public OrderNotFoundException(String id) {
		super("order with id: " + id + " not found");
	}
}
