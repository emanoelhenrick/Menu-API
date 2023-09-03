package com.emhk.menu.menuapi.presentation.controllers.dtos.product.input.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.emhk.menu.menuapi.domain.models.Product;
import com.emhk.menu.menuapi.presentation.controllers.dtos.product.input.ProductInput;

@Component
public class ProductDisassembler {

  private final ModelMapper mapper;

  ProductDisassembler(ModelMapper modelMapper) {
    this.mapper = modelMapper;
  }

  public Product toDomainModel(ProductInput input) {
    return mapper.map(input, Product.class);
  }

  public void copyToDomainObject(ProductInput input, Product product) {
    mapper.map(input, product);
  }
}
