package com.emhk.menu.menuapi.presentation.dtos.product.output.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emhk.menu.menuapi.domain.models.Product;
import com.emhk.menu.menuapi.presentation.dtos.product.output.ProductOutput;

@Component
public class ProductAssembler {
  
  @Autowired
  private ModelMapper mapper;

  public ProductOutput toDTO(Product product) {
    return mapper.map(product, ProductOutput.class);
  }

  public List<ProductOutput> toDTOCollection(List<Product> products) {
    return products.stream()
      .map(product -> toDTO(product))
      .toList();
  }
}
