package com.emhk.menu.menuapi.data.services.product;

import com.emhk.menu.menuapi.domain.exceptions.product.ProductNotFoundException;
import com.emhk.menu.menuapi.domain.models.Product;
import com.emhk.menu.menuapi.domain.repository.ProductRepository;
import com.emhk.menu.menuapi.domain.services.product.LoadProduct;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DbLoadProduct implements LoadProduct {

	private final ProductRepository productRepository;

	DbLoadProduct(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product load(String id) {
		return productRepository.findById(UUID.fromString(id))
			.orElseThrow(() -> new ProductNotFoundException(id));
	}

}
