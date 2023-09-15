package com.emhk.menu.menuapi.presentation.controllers.dtos.productImage.output.assembler;

import com.emhk.menu.menuapi.domain.models.ProductImage;
import com.emhk.menu.menuapi.presentation.controllers.dtos.productImage.output.ProductImageOutput;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductImageAssembler {

  private final ModelMapper mapper;

  ProductImageAssembler(ModelMapper modelMapper) {
    this.mapper = modelMapper;
  }

  public ProductImageOutput toDTO(ProductImage productImage) {
    return mapper.map(productImage, ProductImageOutput.class);
  }

}
