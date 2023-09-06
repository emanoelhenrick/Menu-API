package com.emhk.menu.menuapi.presentation.controllers.product;

import com.emhk.menu.menuapi.domain.models.Establishment;
import com.emhk.menu.menuapi.presentation.controllers.dtos.product.input.disassembler.ProductDisassembler;
import com.emhk.menu.menuapi.presentation.controllers.dtos.product.output.assembler.ProductAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.emhk.menu.menuapi.presentation.controllers.dtos.product.input.ProductInput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.product.output.ProductOutput;
import com.emhk.menu.menuapi.domain.services.product.AddProduct;
import jakarta.validation.Valid;

import java.util.UUID;

@RestController
@RequestMapping("/establishment/{establishmentId}/products")
public class AddProductController {

  @Autowired
  private AddProduct addProduct;

  @Autowired
  private ProductDisassembler disassembler;

  @Autowired
  private ProductAssembler assembler;

  @PostMapping
  public ProductOutput addNewProduct(@PathVariable String establishmentId, @Valid @RequestBody ProductInput input) {
    var productToSave = disassembler.toDomainModel(input);
    var establishment = new Establishment();
    establishment.setId(UUID.fromString(establishmentId));
    productToSave.setEstablishment(establishment);
    var product = addProduct.add(productToSave);
    return assembler.toDTO(product);
  }
  
}
