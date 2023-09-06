package com.emhk.menu.menuapi.presentation.controllers.dtos.product.output.assembler;

import java.util.List;

import com.emhk.menu.menuapi.presentation.controllers.dtos.product.output.ProductOutput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.product.output.ProductShortOutput;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.emhk.menu.menuapi.domain.models.Product;

@Component
public class ProductAssembler {

  private final ModelMapper mapper;

  ProductAssembler(ModelMapper modelMapper) {
    this.mapper = modelMapper;
  }

  public ProductOutput toDTO(Product product) {
    return mapper.map(product, ProductOutput.class);
  }

  public List<ProductOutput> toDTOCollection(List<Product> products) {
    return products.stream()
      .map(product -> toDTO(product))
      .toList();
  }

  public ProductShortOutput toShortDTO(Product product) {
    return mapper.map(product, ProductShortOutput.class);
  }

  public List<ProductShortOutput> toShortDTOCollection(List<Product> products) {
    return products.stream()
      .map(product -> toShortDTO(product))
      .toList();
  }
}
