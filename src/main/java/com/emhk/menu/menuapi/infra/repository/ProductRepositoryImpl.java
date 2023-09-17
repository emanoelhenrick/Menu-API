package com.emhk.menu.menuapi.infra.repository;

import com.emhk.menu.menuapi.domain.models.ProductImage;
import com.emhk.menu.menuapi.domain.repository.customQueries.ProductRepositoryQueries;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryQueries {

  @PersistenceContext
  private EntityManager manager;

  @Override
  @Transactional
  public ProductImage saveProductImage(ProductImage productImage) {
    return manager.merge(productImage);
  }

  @Transactional
  public void delete(ProductImage productImage) {
    manager.remove(productImage);
  }

}
