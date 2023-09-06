package com.emhk.menu.menuapi.domain.exceptions.product;

import com.emhk.menu.menuapi.domain.exceptions.BusinessException;

public class ProductNotAvailable extends BusinessException {
	public ProductNotAvailable(String id) {
		super("product with id " + id + "is inactive");
	}
}
