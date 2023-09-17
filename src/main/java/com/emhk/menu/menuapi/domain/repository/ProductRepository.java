package com.emhk.menu.menuapi.domain.repository;

import com.emhk.menu.menuapi.domain.models.ProductImage;
import com.emhk.menu.menuapi.domain.repository.customQueries.ProductRepositoryQueries;
import org.springframework.data.jpa.repository.JpaRepository;

import com.emhk.menu.menuapi.domain.models.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;


public interface ProductRepository extends JpaRepository<Product, UUID>, ProductRepositoryQueries {

  @Query("select f from ProductImage f join f.product p" +
    "where p.restaurant.id = :restaurantId and p.product.id = :productId")
  Optional<ProductImage> findImageById(UUID restaurantId, UUID productId);
}
