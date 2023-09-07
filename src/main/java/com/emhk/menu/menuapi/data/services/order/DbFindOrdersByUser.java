package com.emhk.menu.menuapi.data.services.order;

import com.emhk.menu.menuapi.domain.exceptions.user.UserNotFoundException;
import com.emhk.menu.menuapi.domain.models.Order;
import com.emhk.menu.menuapi.domain.repository.UserRepository;
import com.emhk.menu.menuapi.domain.services.order.FindOrdersByUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DbFindOrdersByUser implements FindOrdersByUser {

  private final UserRepository userRepository;

  DbFindOrdersByUser(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<Order> find(String userId) {
    var user = userRepository.findById(UUID.fromString(userId))
      .orElseThrow(() -> new UserNotFoundException(userId));
    return user.getOrders();
  }

}
