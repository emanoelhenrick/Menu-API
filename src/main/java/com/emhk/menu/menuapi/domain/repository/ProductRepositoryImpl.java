package com.emhk.menu.menuapi.domain.repository;

import com.emhk.menu.menuapi.domain.models.ProductImage;
import com.emhk.menu.menuapi.domain.repository.customQueries.ProductRepositoryQueries;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryQueries {

  @PersistenceContext
  private EntityManager manager;

  @Override
  @Transactional
  public ProductImage saveProductImage(ProductImage productImage) {
    return manager.merge(productImage);
  }

  @Override
  public Optional<ProductImage> findProductImage(String productId) {
    return Optional.ofNullable(manager.find(ProductImage.class, UUID.fromString(productId)));
  }

  @Override
  @Transactional
  public void deleteProductImage(ProductImage productImage) {
    manager.remove(productImage);
  }

}
