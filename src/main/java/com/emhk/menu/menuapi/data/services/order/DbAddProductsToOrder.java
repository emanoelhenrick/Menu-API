package com.emhk.menu.menuapi.data.services.order;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.emhk.menu.menuapi.domain.exceptions.order.OrderNotFoundException;
import com.emhk.menu.menuapi.domain.exceptions.product.ProductNotAvailable;
import com.emhk.menu.menuapi.domain.exceptions.product.ProductNotFoundException;
import com.emhk.menu.menuapi.domain.models.ProductOrder;
import com.emhk.menu.menuapi.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.models.Order;
import com.emhk.menu.menuapi.domain.repository.OrderRepository;
import com.emhk.menu.menuapi.domain.services.order.AddProductsToOrder;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DbAddProductsToOrder implements AddProductsToOrder {

  private final OrderRepository orderRepository;
  private final ProductRepository productRepository;

  DbAddProductsToOrder(OrderRepository orderRepository, ProductRepository productRepository) {
    this.orderRepository = orderRepository;
    this.productRepository = productRepository;
  }

  @Override
  public Order add(String orderUUID, List<ProductOrder> products) {
    var order = orderRepository
      .findById(UUID.fromString(orderUUID))
      .orElseThrow(() -> new OrderNotFoundException(orderUUID));

    products.forEach(product -> order.getProducts().add(product));

    var totalPrice = BigDecimal.ZERO;
    for (ProductOrder productOrder : order.getProducts()) {
      var productId = productOrder.getProductId();
      var product = productRepository.findById(UUID.fromString(productId))
        .orElseThrow(() -> new ProductNotFoundException(productId));

      if (!product.getActive()) throw new ProductNotAvailable(productId);

      productOrder.setUnitPrice(product.getPrice());
      var productTotalPrice = product.getPrice()
        .multiply(BigDecimal.valueOf(productOrder.getQuantity()));
      totalPrice = totalPrice.add(productTotalPrice);
    }
    order.setTotalPrice(totalPrice);

    return orderRepository.save(order);
  }
  
}
