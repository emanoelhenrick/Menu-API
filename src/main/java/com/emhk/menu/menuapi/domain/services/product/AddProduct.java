package com.emhk.menu.menuapi.domain.services.product;

import com.emhk.menu.menuapi.domain.services.dtos.product.input.ProductInput;
import com.emhk.menu.menuapi.domain.services.dtos.product.output.ProductOutput;

public interface AddProduct {
  public ProductOutput add(ProductInput product);
}
