package com.emhk.menu.menuapi.presentation.controllers.product.productImage;

import com.emhk.menu.menuapi.domain.exceptions.BusinessException;
import com.emhk.menu.menuapi.domain.exceptions.EntityNotFoundException;
import com.emhk.menu.menuapi.domain.services.product.productImage.LoadProductImage;
import com.emhk.menu.menuapi.domain.services.storage.ImageStorageService;
import com.emhk.menu.menuapi.presentation.controllers.dtos.productImage.output.ProductImageOutput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.productImage.output.assembler.ProductImageAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @GetMapping
  public ResponseEntity<InputStreamResource> serveProductImage(
    @PathVariable String productId,
    @RequestHeader(name = "accept") String acceptHeader
  ) throws HttpMediaTypeNotAcceptableException {
    try {
      var productImage = loadProductImage.load(productId);
      var imageStream = imageStorageService.getImage(productImage.getFileName());
      var mediaTypes = MediaType.parseMediaTypes(acceptHeader);
      var imageMediaType = MediaType.parseMediaType(productImage.getContentType());
      verifyMediaType(imageMediaType, mediaTypes);

      return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(new InputStreamResource(imageStream));
    } catch (EntityNotFoundException ex) {
      return ResponseEntity.notFound().build();
    }
  }

  private void verifyMediaType(MediaType imageMediaType, List<MediaType> allowedMediaTypes)
    throws HttpMediaTypeNotAcceptableException {
    boolean isAllowed = allowedMediaTypes.stream()
      .anyMatch(mediaType -> mediaType.isCompatibleWith(imageMediaType));
    if (!isAllowed) {
      throw new HttpMediaTypeNotAcceptableException(allowedMediaTypes);
    }
  }

}
