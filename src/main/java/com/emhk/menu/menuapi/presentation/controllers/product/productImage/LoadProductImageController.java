package com.emhk.menu.menuapi.presentation.controllers.product.productImage;

import com.emhk.menu.menuapi.domain.services.product.productImage.LoadProductImage;
import com.emhk.menu.menuapi.presentation.controllers.dtos.productImage.output.ProductImageOutput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.productImage.output.assembler.ProductImageAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/{productId}/image")
public class LoadProductImageController {

  @Autowired
  private LoadProductImage loadProductImage;

  @Autowired
  private ProductImageAssembler assembler;

  @GetMapping
  public ProductImageOutput loadProductImage(@PathVariable String productId) {
    var productImage = loadProductImage.load(productId);
    return assembler.toDTO(productImage);
  }
}
