package com.emhk.menu.menuapi.presentation.controllers.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emhk.menu.menuapi.domain.services.product.AddProduct;
import com.emhk.menu.menuapi.presentation.dtos.product.input.ProductInput;
import com.emhk.menu.menuapi.presentation.dtos.product.input.disassembler.ProductDisassembler;
import com.emhk.menu.menuapi.presentation.dtos.product.output.ProductOutput;
import com.emhk.menu.menuapi.presentation.dtos.product.output.assembler.ProductAssembler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class AddProductController {

  @Autowired
  private AddProduct addProduct;

  @Autowired
  private ProductAssembler assembler;

  @Autowired
  private ProductDisassembler disassembler;

  @PostMapping
  public ProductOutput addProduct(@Valid @RequestBody ProductInput input) {
    var newProduct = disassembler.toDomainModel(input);
    var product = addProduct.add(newProduct);
    return assembler.toDTO(product);
  }
  
}
