package com.emhk.menu.menuapi.domain.repository.customQueries;

import com.emhk.menu.menuapi.domain.models.ProductImage;

public interface ProductRepositoryQueries {

  ProductImage saveProductImage(ProductImage productImage);
  ProductImage findProductImage(String productId);
  void deleteProductImage(ProductImage productImage);

}
