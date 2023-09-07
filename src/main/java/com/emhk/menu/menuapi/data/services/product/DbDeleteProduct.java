package com.emhk.menu.menuapi.data.services.product;

import com.emhk.menu.menuapi.domain.exceptions.InUseEntityException;
import com.emhk.menu.menuapi.domain.exceptions.product.ProductNotFoundException;
import com.emhk.menu.menuapi.domain.repository.ProductRepository;
import com.emhk.menu.menuapi.domain.services.product.DeleteProduct;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DbDeleteProduct implements DeleteProduct {

	private final ProductRepository productRepository;

	DbDeleteProduct(ProductRepository productRepository) {
		this.productRepository = productRepository;

	}

	@Override
	public void delete(String id) {
		try {
			productRepository.deleteById(UUID.fromString(id));
			productRepository.flush();
		} catch (DataIntegrityViolationException ex) {
			throw new InUseEntityException(id);
		} catch (EmptyResultDataAccessException ex) {
			throw new ProductNotFoundException(id);
		}

	}

}
