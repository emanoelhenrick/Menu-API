package com.emhk.menu.menuapi.data.services.product.productImage;

import com.emhk.menu.menuapi.domain.exceptions.product.ProductNotFoundException;
import com.emhk.menu.menuapi.domain.models.ProductImage;
import com.emhk.menu.menuapi.domain.repository.ProductRepository;
import com.emhk.menu.menuapi.domain.services.product.productImage.AddProductImage;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DbAddProductImage implements AddProductImage {

  private final ProductRepository productRepository;

  DbAddProductImage(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public ProductImage add(ProductImage productImage, String productId) {
    var product = productRepository.findById(UUID.fromString(productId))
      .orElseThrow(() -> new ProductNotFoundException(productId));

    var establishmentId = product.getEstablishment().getId();
    var imageOpt = productRepository.findImageById(establishmentId, UUID.fromString(productId));

    imageOpt.ifPresent(productRepository::delete);

    productImage.setId(UUID.fromString(productId));
    productImage.setProduct(product);
    return productRepository.saveProductImage(productImage);
  }
}
