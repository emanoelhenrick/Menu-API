package com.emhk.menu.menuapi.domain.exceptions.product.productImage;

import com.emhk.menu.menuapi.domain.exceptions.EntityNotFoundException;

public class ProductImageNotFoundException extends EntityNotFoundException {
  public ProductImageNotFoundException(String id) {
    super("there is no Product Image with id " + id);
  }
}
