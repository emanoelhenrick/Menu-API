package com.emhk.menu.menuapi.data.services.order;

import com.emhk.menu.menuapi.domain.exceptions.user.UserNotFoundException;
import com.emhk.menu.menuapi.domain.models.Order;
import com.emhk.menu.menuapi.domain.repository.UserRepository;
import com.emhk.menu.menuapi.domain.services.order.FindOrdersByUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbFindOrdersByUser implements FindOrdersByUser {

  private final UserRepository userRepository;

  DbFindOrdersByUser(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<Order> find(String username) {
    var user = userRepository.findByUsername(username)
      .orElseThrow(() -> new UserNotFoundException(username));
    return user.getOrders();
  }

}
