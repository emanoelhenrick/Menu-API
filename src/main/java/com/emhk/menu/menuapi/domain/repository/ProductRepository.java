package com.emhk.menu.menuapi.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emhk.menu.menuapi.domain.models.Product;
import java.util.UUID;


public interface ProductRepository extends JpaRepository<Product, String> {
  Optional<Product> findById(UUID id);
}
