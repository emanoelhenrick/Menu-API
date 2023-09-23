package com.emhk.menu.menuapi.domain.repository.customQueries;

import com.emhk.menu.menuapi.domain.models.ProductImage;

import java.util.Optional;

public interface ProductRepositoryQueries {

  ProductImage saveProductImage(ProductImage productImage);
  Optional<ProductImage> findProductImage(String productId);
  void deleteProductImage(ProductImage productImage);

}
