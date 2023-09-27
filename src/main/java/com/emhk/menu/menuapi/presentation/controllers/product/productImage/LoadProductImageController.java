package com.emhk.menu.menuapi.presentation.controllers.product.productImage;

import com.emhk.menu.menuapi.domain.exceptions.EntityNotFoundException;
import com.emhk.menu.menuapi.domain.services.product.productImage.LoadProductImage;
import com.emhk.menu.menuapi.domain.services.storage.ImageStorageService;
import com.emhk.menu.menuapi.presentation.controllers.dtos.productImage.output.ProductImageOutput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.productImage.output.assembler.ProductImageAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
  private ImageStorageService imageStorageService;

  @Autowired
  private ProductImageAssembler assembler;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ProductImageOutput loadProductImage(@PathVariable String productId) {
    var productImage = loadProductImage.load(productId);
    return assembler.toDTO(productImage);
  }

  @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
  public ResponseEntity<InputStreamResource> serveProductImage(@PathVariable String productId) {
    try {
      var productImage = loadProductImage.load(productId);
      var imageStream = imageStorageService.getImage(productImage.getFileName());
      return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(new InputStreamResource(imageStream));
    } catch (EntityNotFoundException ex) {
      return ResponseEntity.notFound().build();
    }
  }

}
