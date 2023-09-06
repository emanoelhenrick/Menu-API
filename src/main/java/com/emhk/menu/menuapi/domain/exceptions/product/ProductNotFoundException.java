package com.emhk.menu.menuapi.domain.exceptions.product;

import com.emhk.menu.menuapi.domain.exceptions.EntityNotFoundException;

public class ProductNotFoundException extends EntityNotFoundException {
	public ProductNotFoundException (String id) {
		super("there is no Product with id " + id);
	}
}
