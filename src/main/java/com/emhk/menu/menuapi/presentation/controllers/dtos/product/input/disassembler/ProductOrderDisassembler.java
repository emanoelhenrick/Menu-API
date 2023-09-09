package com.emhk.menu.menuapi.presentation.controllers.dtos.product.input.disassembler;

import com.emhk.menu.menuapi.domain.models.ProductOrder;
import com.emhk.menu.menuapi.presentation.controllers.dtos.product.input.ProductOrderInput;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductOrderDisassembler {

  private final ModelMapper mapper;

  ProductOrderDisassembler(ModelMapper modelMapper) {
    this.mapper = modelMapper;
  }

  public ProductOrder toDomainModel(ProductOrderInput input) {
    return mapper.map(input, ProductOrder.class);
  }

  public void copyToDomainObject(ProductOrderInput input, ProductOrder productOrder) {
    mapper.map(input, productOrder);
  }

}
