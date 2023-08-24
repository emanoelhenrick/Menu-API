package com.emhk.menu.menuapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emhk.menu.menuapi.domain.models.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
  
}
