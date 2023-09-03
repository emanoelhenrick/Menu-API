package com.emhk.menu.menuapi.data.services.product;

import com.emhk.menu.menuapi.domain.models.Product;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.repository.ProductRepository;
import com.emhk.menu.menuapi.domain.services.product.AddProduct;

@Service
public class DbAddProduct implements AddProduct {

  private final ProductRepository productRepository;

  DbAddProduct(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product add(Product product) {
    return productRepository.save(product);
  }
  
}
