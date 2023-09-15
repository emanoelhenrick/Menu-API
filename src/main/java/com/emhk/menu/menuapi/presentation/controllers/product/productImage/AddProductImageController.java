package com.emhk.menu.menuapi.presentation.controllers.product.productImage;

import com.emhk.menu.menuapi.domain.services.product.productImage.AddProductImage;
import com.emhk.menu.menuapi.presentation.controllers.dtos.productImage.input.ProductImageInput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.productImage.input.disassembler.ProductImageDisassembler;
import com.emhk.menu.menuapi.presentation.controllers.dtos.productImage.output.ProductImageOutput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.productImage.output.assembler.ProductImageAssembler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/{productId}/image")
public class AddProductImageController {

  @Autowired
  private AddProductImage addProductImage;

  @Autowired
  private ProductImageDisassembler disassembler;

  @Autowired
  private ProductImageAssembler assembler;

  @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ProductImageOutput addImage(
    @PathVariable String productId,
    @Valid ProductImageInput input
  ) {
    var imageToSave = disassembler.toDomainModel(input);
    var savedImage = addProductImage.add(imageToSave, productId);
    return assembler.toDTO(savedImage);
  }
}
