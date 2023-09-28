package com.emhk.menu.menuapi.presentation.controllers.product.productImage;

import com.emhk.menu.menuapi.domain.services.product.productImage.DeleteProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/{productId}/image")
public class DeleteProductImageController {

  @Autowired
  private DeleteProductImage deleteProductImage;

  @DeleteMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteImage(@PathVariable String productId) {
    deleteProductImage.delete(productId);
  }
}
