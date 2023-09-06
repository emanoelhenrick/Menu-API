package com.emhk.menu.menuapi.presentation.controllers.product;

import com.emhk.menu.menuapi.domain.services.product.DeleteProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/{productId}")
public class DeleteProductController {

	@Autowired
	private DeleteProduct deleteProduct;

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping
	public void deleteProductById(@PathVariable String productId) {
		deleteProduct.delete(productId);
	}
}
