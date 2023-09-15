package com.emhk.menu.menuapi.presentation.controllers.dtos.productImage.output;

import com.emhk.menu.menuapi.presentation.controllers.dtos.product.output.ProductShortOutput;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductImageOutput {
  private ProductShortOutput product;
  private String fileName;
  private String contentType;
  private Long fileSize;
}
