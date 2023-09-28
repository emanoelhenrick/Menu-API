package com.emhk.menu.menuapi.data.services.product.productImage;

import com.emhk.menu.menuapi.domain.exceptions.product.productImage.ProductImageNotFoundException;
import com.emhk.menu.menuapi.domain.repository.ProductRepository;
import com.emhk.menu.menuapi.domain.services.product.productImage.DeleteProductImage;
import com.emhk.menu.menuapi.domain.services.storage.ImageStorageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DbDeleteProductImage implements DeleteProductImage {

  private final ImageStorageService imageStorageService;
  private final ProductRepository productRepository;

  DbDeleteProductImage(
    ImageStorageService imageStorageService,
    ProductRepository productRepository
  ) {
    this.imageStorageService = imageStorageService;
    this.productRepository = productRepository;
  }

  @Override
  @Transactional
  public void delete(String productId) {
    var productImage = productRepository.findProductImage(productId)
      .orElseThrow(() -> new ProductImageNotFoundException(productId));
    productRepository.deleteProductImage(productImage);
    productRepository.flush();
    imageStorageService.remove(productImage.getFileName());
  }
}
