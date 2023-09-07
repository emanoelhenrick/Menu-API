package com.emhk.menu.menuapi.domain.exceptions.product;

import com.emhk.menu.menuapi.domain.exceptions.EntityNotAvailable;

public class ProductNotAvailable extends EntityNotAvailable {
	public ProductNotAvailable(String id) {
		super("product with id " + id + "is inactive");
	}
}
