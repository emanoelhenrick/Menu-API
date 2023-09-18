package com.emhk.menu.menuapi.domain.services.product.productImage;

import com.emhk.menu.menuapi.domain.models.ProductImage;

import java.io.InputStream;

public interface AddProductImage {
  ProductImage add(ProductImage productImage, String productId, InputStream inputStream);
}
