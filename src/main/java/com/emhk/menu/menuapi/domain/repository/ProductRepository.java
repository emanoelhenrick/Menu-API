package com.emhk.menu.menuapi.domain.repository;

import com.emhk.menu.menuapi.domain.models.ProductImage;
import com.emhk.menu.menuapi.domain.repository.customQueries.ProductRepositoryQueries;
import org.springframework.data.jpa.repository.JpaRepository;

import com.emhk.menu.menuapi.domain.models.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID>, ProductRepositoryQueries {

//  @Query("select i from ProductImage i join i.product p where " +
//    "p.establishment.id = :establishmentId and p.id = :productId")
  @Query("from ProductImage where product.establishment.id = :establishmentId and product.id = :productId")
  Optional<ProductImage> findImageById(UUID establishmentId, UUID productId);

}
