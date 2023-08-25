package com.emhk.menu.menuapi.data.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.models.Product;
import com.emhk.menu.menuapi.domain.repository.ProductRepository;
import com.emhk.menu.menuapi.domain.services.dtos.product.input.ProductInput;
import com.emhk.menu.menuapi.domain.services.dtos.product.input.disassembler.ProductDisassembler;
import com.emhk.menu.menuapi.domain.services.dtos.product.output.ProductOutput;
import com.emhk.menu.menuapi.domain.services.dtos.product.output.assembler.ProductAssembler;
import com.emhk.menu.menuapi.domain.services.product.AddProduct;

@Service
public class DbAddProduct implements AddProduct {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductDisassembler disassembler;

  @Autowired
  private ProductAssembler assembler;

  @Override
  public ProductOutput add(ProductInput input) {
    var product = disassembler.toDomainModel(input);
    return assembler.toDTO(productRepository.save(product));
  }
  
}
