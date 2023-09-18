package com.emhk.menu.menuapi.data.services.product.productImage;

import com.emhk.menu.menuapi.domain.exceptions.BusinessException;
import com.emhk.menu.menuapi.domain.exceptions.product.ProductNotFoundException;
import com.emhk.menu.menuapi.domain.models.ProductImage;
import com.emhk.menu.menuapi.domain.repository.ProductRepository;
import com.emhk.menu.menuapi.domain.services.product.productImage.AddProductImage;
import com.emhk.menu.menuapi.domain.services.storage.SaveImageToStorage;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class DbAddProductImage implements AddProductImage {

  private final ProductRepository productRepository;
  private final SaveImageToStorage saveImageToStorage;

  DbAddProductImage(ProductRepository productRepository, SaveImageToStorage saveImageToStorage) {
    this.productRepository = productRepository;
    this.saveImageToStorage = saveImageToStorage;
  }

  public ProductImage add(ProductImage productImage, String productId, InputStream inputStream) {
    var product = productRepository.findById(UUID.fromString(productId))
      .orElseThrow(() -> new ProductNotFoundException(productId));

    var establishmentId = product.getEstablishment().getId();
    var imageOpt = productRepository.findImageById(establishmentId, UUID.fromString(productId));

    imageOpt.ifPresent(productRepository::delete);

    productImage.setId(UUID.fromString(productId));
    productImage.setProduct(product);
    var image = productRepository.saveProductImage(productImage);
    productRepository.flush();

    var newImage = SaveImageToStorage.NewImage.builder()
      .filename(image.getFileName())
      .inputStream(inputStream)
      .build();

    try {
      saveImageToStorage.save(newImage);
    } catch (IOException e) {
      throw new BusinessException(e.getMessage());
    }

    return image;
  }
}
