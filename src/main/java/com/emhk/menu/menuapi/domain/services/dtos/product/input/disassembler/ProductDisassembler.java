package com.emhk.menu.menuapi.domain.services.dtos.product.input.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emhk.menu.menuapi.domain.models.Product;
import com.emhk.menu.menuapi.domain.services.dtos.product.input.ProductInput;

@Component
public class ProductDisassembler {
  
  @Autowired
  private ModelMapper mapper;

  public Product toDomainModel(ProductInput input) {
    return mapper.map(input, Product.class);
  }

  public void copyToDomainObject(ProductInput input, Product product) {
    mapper.map(input, product);
  }
}
