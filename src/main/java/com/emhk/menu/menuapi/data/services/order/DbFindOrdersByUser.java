package com.emhk.menu.menuapi.data.services.order;

import com.emhk.menu.menuapi.domain.exceptions.user.UserNotFoundException;
import com.emhk.menu.menuapi.domain.models.Order;
import com.emhk.menu.menuapi.domain.repository.OrderRepository;
import com.emhk.menu.menuapi.domain.repository.UserRepository;
import com.emhk.menu.menuapi.domain.services.order.FindOrdersByUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DbFindOrdersByUser implements FindOrdersByUser {

  private final OrderRepository orderRepository;
  private final UserRepository userRepository;

  DbFindOrdersByUser(OrderRepository orderRepository, UserRepository userRepository) {
    this.orderRepository = orderRepository;
    this.userRepository = userRepository;
  }

  @Override
  public Page<Order> find(String username, Pageable pageable) {
    userRepository.findByUsername(username)
      .orElseThrow(() -> new UserNotFoundException(username));
    return orderRepository.findAllByCustomerUsername(username, pageable);
  }

}
