package com.emhk.menu.menuapi.presentation.controllers.order;

import com.emhk.menu.menuapi.domain.services.order.FindOrdersByUser;
import com.emhk.menu.menuapi.presentation.controllers.dtos.order.output.OrderOutput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.order.output.assembler.OrderAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/{username}/orders")
public class FindOrdersByUserController {

  @Autowired
  private FindOrdersByUser findOrdersByUser;

  @Autowired
  private OrderAssembler assembler;

  @GetMapping
  public Page<OrderOutput> findOrders(@PathVariable String username, Pageable pageable) {
    var ordersPage = findOrdersByUser.find(username, pageable);
    var orders = assembler.toDTOCollection(ordersPage.getContent());
    return new PageImpl<OrderOutput>(orders, pageable, ordersPage.getTotalElements());
  }

}
