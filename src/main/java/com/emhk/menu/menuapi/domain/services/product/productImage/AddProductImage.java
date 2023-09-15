package com.emhk.menu.menuapi.domain.services.product.productImage;

import com.emhk.menu.menuapi.domain.models.ProductImage;

public interface AddProductImage {
  ProductImage add(ProductImage productImage, String productId);
}
