package com.emhk.menu.menuapi.data.services.order;

import com.emhk.menu.menuapi.domain.exceptions.BusinessException;
import com.emhk.menu.menuapi.domain.exceptions.establishment.EstablishmentNotFoundException;
import com.emhk.menu.menuapi.domain.exceptions.user.UserNotFoundException;
import com.emhk.menu.menuapi.domain.models.Product;
import com.emhk.menu.menuapi.domain.models.ProductOrder;
import com.emhk.menu.menuapi.domain.models.UserRole;
import com.emhk.menu.menuapi.domain.repository.EstablishmentRepository;
import com.emhk.menu.menuapi.domain.repository.ProductRepository;
import com.emhk.menu.menuapi.domain.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.models.Order;
import com.emhk.menu.menuapi.domain.repository.OrderRepository;
import com.emhk.menu.menuapi.domain.services.order.CreateOrder;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
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
  @Transactional
  public Order create(String establishmentId, Order order) {
    var customer = userRepository
      .findById(order.getCustomer().getId())
      .orElseThrow(() -> new UserNotFoundException("User not found"));
    if (customer.getRole() != UserRole.CUSTOMER) {
      throw new BusinessException("Only customers can place an order.");
    }
    var establishment = establishmentRepository
      .findById(UUID.fromString(establishmentId))
      .orElseThrow(() -> new EstablishmentNotFoundException(establishmentId));
    order.setEstablishment(establishment);
    if (order.getProducts().isEmpty()) {
      throw new BusinessException("The order must have at least one product.");
    }
    var totalPrice = BigDecimal.ZERO;
    for (ProductOrder product : order.getProducts()) {
      var productRef = productRepository.getReferenceById(product.getProduct().getId());
      var productTotalPrice = productRef.getPrice()
        .multiply(BigDecimal.valueOf(product.getQuantity()));
      totalPrice = totalPrice.add(productTotalPrice);
    }
    order.setTotalPrice(totalPrice);
    return orderRepository.save(order);
  }
  
}
