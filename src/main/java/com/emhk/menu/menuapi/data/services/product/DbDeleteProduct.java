package com.emhk.menu.menuapi.data.services.product;

import com.emhk.menu.menuapi.domain.exceptions.InUseEntityException;
import com.emhk.menu.menuapi.domain.repository.ProductRepository;
import com.emhk.menu.menuapi.domain.services.product.DeleteProduct;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class DbDeleteProduct implements DeleteProduct {

	private final ProductRepository productRepository;

	DbDeleteProduct(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void delete(String id) {
		var productOptional = productRepository.findById(UUID.fromString(id));
		if (productOptional.isEmpty()) return;
		var product = productOptional.get();
		try {
			productRepository.delete(product);
		} catch (DataIntegrityViolationException ex) {
			if (product.getActive()) product.setActive(false);
			throw new InUseEntityException(id);
		}
	}
}
