package com.emhk.menu.menuapi.data.services.order;

import com.emhk.menu.menuapi.domain.exceptions.BusinessException;
import com.emhk.menu.menuapi.domain.exceptions.Order.OrderEmptyException;
import com.emhk.menu.menuapi.domain.exceptions.establishment.AccessDeniedException;
import com.emhk.menu.menuapi.domain.exceptions.establishment.EstablishmentNotFoundException;
import com.emhk.menu.menuapi.domain.exceptions.product.ProductNotAvailable;
import com.emhk.menu.menuapi.domain.exceptions.product.ProductNotFoundException;
import com.emhk.menu.menuapi.domain.exceptions.user.UserNotFoundException;
import com.emhk.menu.menuapi.domain.models.ProductOrder;
import com.emhk.menu.menuapi.domain.models.UserRole;
import com.emhk.menu.menuapi.domain.repository.EstablishmentRepository;
import com.emhk.menu.menuapi.domain.repository.ProductRepository;
import com.emhk.menu.menuapi.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.models.Order;
import com.emhk.menu.menuapi.domain.repository.OrderRepository;
import com.emhk.menu.menuapi.domain.services.order.CreateOrder;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@Transactional
public class DbCreateOrder implements CreateOrder {

  private final OrderRepository orderRepository;
  private final EstablishmentRepository establishmentRepository;
  private final ProductRepository productRepository;
  private final UserRepository userRepository;

  DbCreateOrder(
    OrderRepository orderRepository,
    EstablishmentRepository establishmentRepository,
    ProductRepository productRepository,
    UserRepository userRepository
  ) {
    this.orderRepository = orderRepository;
    this.establishmentRepository = establishmentRepository;
    this.productRepository = productRepository;
    this.userRepository = userRepository;
  }

  @Override
  public Order create(String establishmentId, Order order) {
    if (order.getProducts().isEmpty()) throw new OrderEmptyException();

    var customerId = order.getCustomer().getId();
    var customer = userRepository
      .findById(customerId)
      .orElseThrow(() -> new UserNotFoundException(customerId.toString()));
    if (customer.getRole() != UserRole.CUSTOMER) throw new AccessDeniedException();

    var establishment = establishmentRepository
      .findById(UUID.fromString(establishmentId))
      .orElseThrow(() -> new EstablishmentNotFoundException(establishmentId));
    order.setEstablishment(establishment);

    var totalPrice = BigDecimal.ZERO;
    for (ProductOrder product : order.getProducts()) {
      var productId = product.getProduct().getId();
      var productRef = productRepository.findById(productId)
        .orElseThrow(() -> new ProductNotFoundException(productId.toString()));
      if (!productRef.getActive()) {
        throw new ProductNotAvailable(productId.toString());
      }

      var productTotalPrice = productRef.getPrice()
        .multiply(BigDecimal.valueOf(product.getQuantity()));
      totalPrice = totalPrice.add(productTotalPrice);
    }
    order.setTotalPrice(totalPrice);

    return orderRepository.save(order);
  }
  
}
