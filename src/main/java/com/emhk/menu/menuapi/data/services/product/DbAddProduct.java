package com.emhk.menu.menuapi.data.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.models.Product;
import com.emhk.menu.menuapi.domain.repository.ProductRepository;
import com.emhk.menu.menuapi.domain.services.product.AddProduct;

@Service
public class DbAddProduct implements AddProduct {

  @Autowired
  private ProductRepository repository;

  @Override
  public Product add(Product product) {
    return repository.save(product);
  }
  
}
