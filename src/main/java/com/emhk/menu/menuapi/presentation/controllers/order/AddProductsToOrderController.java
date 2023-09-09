package com.emhk.menu.menuapi.presentation.controllers.order;

import com.emhk.menu.menuapi.domain.models.ProductOrder;
import com.emhk.menu.menuapi.domain.services.order.AddProductsToOrder;
import com.emhk.menu.menuapi.presentation.controllers.dtos.product.input.AddProductOrderInput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.product.input.disassembler.ProductOrderDisassembler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders/{orderId}/products")
public class AddProductsToOrderController {

  @Autowired
  private AddProductsToOrder addProductsToOrder;

  @Autowired
  private ProductOrderDisassembler disassembler;

  @PutMapping
  public void addProductsToOrder(
    @PathVariable String orderId, @Valid @RequestBody AddProductOrderInput productsInput
  ) {
    List<ProductOrder> products = productsInput.getProducts().stream()
      .map(productInput -> disassembler.toDomainModel(productInput))
      .toList();
    addProductsToOrder.add(orderId, products);
  }
}
