package com.emhk.menu.menuapi.presentation.controllers.product;

import com.emhk.menu.menuapi.domain.models.Product;
import com.emhk.menu.menuapi.domain.repository.ProductRepository;
import com.emhk.menu.menuapi.presentation.controllers.dtos.product.output.ProductOutput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.product.output.assembler.ProductAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/products/{id}")
public class LoadProductController {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private ProductAssembler assembler;

	@GetMapping
	public ProductOutput carai(@PathVariable String id) {
		var product = repository.findById(UUID.fromString(id)).orElseThrow();
		return assembler.toDTO(product);
	}

}
