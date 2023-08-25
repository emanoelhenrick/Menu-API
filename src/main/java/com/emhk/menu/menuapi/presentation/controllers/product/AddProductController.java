package com.emhk.menu.menuapi.presentation.controllers.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emhk.menu.menuapi.domain.services.dtos.product.input.ProductInput;
import com.emhk.menu.menuapi.domain.services.dtos.product.output.ProductOutput;
import com.emhk.menu.menuapi.domain.services.product.AddProduct;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class AddProductController {

  @Autowired
  private AddProduct addProduct;

  @PostMapping
  public ProductOutput addNewProduct(@Valid @RequestBody ProductInput input) {
    return addProduct.add(input);
  }
  
}
