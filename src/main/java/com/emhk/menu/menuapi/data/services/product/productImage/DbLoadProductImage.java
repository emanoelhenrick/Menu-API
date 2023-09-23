package com.emhk.menu.menuapi.data.services.product.productImage;

import com.emhk.menu.menuapi.domain.exceptions.product.ProductNotFoundException;
import com.emhk.menu.menuapi.domain.exceptions.product.productImage.ProductImageNotFoundException;
import com.emhk.menu.menuapi.domain.models.ProductImage;
import com.emhk.menu.menuapi.domain.repository.ProductRepository;
import com.emhk.menu.menuapi.domain.services.product.productImage.LoadProductImage;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DbLoadProductImage implements LoadProductImage {

  private final ProductRepository productRepository;

  DbLoadProductImage(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public ProductImage load(String productId) {
    var product = productRepository.findById(UUID.fromString(productId))
      .orElseThrow(() -> new ProductNotFoundException(productId));
    return productRepository.findProductImage(productId)
      .orElseThrow(() -> new ProductImageNotFoundException(productId));
  }
}
