package com.emhk.menu.menuapi.domain.exceptions.product;

import com.emhk.menu.menuapi.domain.exceptions.EntityNotAvailableException;

public class ProductNotAvailableException extends EntityNotAvailableException {
	public ProductNotAvailableException(String id) {
		super("product with id " + id + "is inactive");
	}
}
