package com.emhk.menu.menuapi.domain.exceptions.order;

import com.emhk.menu.menuapi.domain.exceptions.BusinessException;

public class OrderEmptyException extends BusinessException {
	public OrderEmptyException() {
		super("The order must have at least one product.");
	}
}
