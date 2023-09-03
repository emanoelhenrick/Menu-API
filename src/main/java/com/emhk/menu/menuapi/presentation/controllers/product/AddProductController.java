package com.emhk.menu.menuapi.presentation.controllers.product;

import com.emhk.menu.menuapi.presentation.controllers.dtos.product.input.disassembler.ProductDisassembler;
import com.emhk.menu.menuapi.presentation.controllers.dtos.product.output.assembler.ProductAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emhk.menu.menuapi.presentation.controllers.dtos.product.input.ProductInput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.product.output.ProductOutput;
import com.emhk.menu.menuapi.domain.services.product.AddProduct;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class AddProductController {

  @Autowired
  private AddProduct addProduct;

  @Autowired
  private ProductDisassembler disassembler;

  @Autowired
  private ProductAssembler assembler;

  @PostMapping
  public ProductOutput addNewProduct(@Valid @RequestBody ProductInput input) {
    var productToSave = disassembler.toDomainModel(input);
    var product = addProduct.add(productToSave);
    return assembler.toDTO(product);
  }
  
}
