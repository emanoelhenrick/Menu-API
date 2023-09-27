package com.emhk.menu.menuapi.data.services.product.productImage;

import com.emhk.menu.menuapi.domain.exceptions.BusinessException;
import com.emhk.menu.menuapi.domain.exceptions.product.ProductNotFoundException;
import com.emhk.menu.menuapi.domain.models.ProductImage;
import com.emhk.menu.menuapi.domain.repository.ProductRepository;
import com.emhk.menu.menuapi.domain.services.product.productImage.AddProductImage;
import com.emhk.menu.menuapi.domain.services.storage.ImageStorageService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class DbAddProductImage implements AddProductImage {

  private final ProductRepository productRepository;
  private final ImageStorageService imageStorageService;

  DbAddProductImage(ProductRepository productRepository, ImageStorageService imageStorageService) {
    this.productRepository = productRepository;
    this.imageStorageService = imageStorageService;
  }

  public ProductImage add(ProductImage productImage, String productId, InputStream inputStream) {
    var product = productRepository.findById(UUID.fromString(productId))
      .orElseThrow(() -> new ProductNotFoundException(productId));

    var establishmentId = product.getEstablishment().getId();
    var imageOpt = productRepository.findImageById(establishmentId, UUID.fromString(productId));

    String oldFilename = null;

    if (imageOpt.isPresent()) {
      oldFilename = imageOpt.get().getFileName();
      productRepository.deleteProductImage(productImage);
    }

    productImage.setId(UUID.fromString(productId));
    productImage.setProduct(product);
    productImage.setFileName(imageStorageService.generateFilename(productImage.getFileName()));
    var image = productRepository.saveProductImage(productImage);
    productRepository.flush();

    var newImage = ImageStorageService.NewImage.builder()
      .filename(image.getFileName())
      .inputStream(inputStream)
      .build();

    try {
      imageStorageService.replace(oldFilename, newImage);
    } catch (IOException e) {
      throw new BusinessException(e.getMessage());
    }

    return image;
  }
}
