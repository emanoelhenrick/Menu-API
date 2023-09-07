package com.emhk.menu.menuapi.presentation.controllers.order;

import com.emhk.menu.menuapi.domain.services.order.FindOrdersByUser;
import com.emhk.menu.menuapi.presentation.controllers.dtos.order.output.OrderOutput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.order.output.assembler.OrderAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/{userId}/orders")
public class FindOrdersByUserController {

  @Autowired
  private FindOrdersByUser findOrdersByUser;

  @Autowired
  private OrderAssembler assembler;

  @GetMapping
  public List<OrderOutput> findOrders(@PathVariable String userId) {
    var orders = findOrdersByUser.find(userId);
    return assembler.toDTOCollection(orders);
  }

}
