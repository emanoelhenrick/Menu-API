package com.emhk.menu.menuapi.presentation.controllers.dtos.productImage.input.disassembler;

import com.emhk.menu.menuapi.domain.models.ProductImage;
import com.emhk.menu.menuapi.presentation.controllers.dtos.productImage.input.ProductImageInput;
import org.springframework.stereotype.Component;

@Component
public class ProductImageDisassembler {

  public ProductImage toDomainModel(ProductImageInput input) {
    var productImage = new ProductImage();
    var file = input.getImage();

    productImage.setFileName(file.getOriginalFilename());
    productImage.setContentType(file.getContentType());
    productImage.setFileSize(file.getSize());

    return productImage;
  }

}
