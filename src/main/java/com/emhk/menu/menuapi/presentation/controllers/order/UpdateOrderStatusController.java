package com.emhk.menu.menuapi.presentation.controllers.order;

import com.emhk.menu.menuapi.domain.models.OrderStatus;
import com.emhk.menu.menuapi.domain.services.order.UpdateOrderStatus;
import com.emhk.menu.menuapi.presentation.controllers.dtos.order.input.OrderStatusInput;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders/{orderId}/status")
public class UpdateOrderStatusController {

  @Autowired
  private UpdateOrderStatus updateOrderStatus;

  @PutMapping
  public void updateOrder(@PathVariable String orderId, @Valid @RequestBody OrderStatusInput orderStatusInput) {
    var orderStatus = OrderStatus.valueOf(orderStatusInput.getStatus().toUpperCase());
    updateOrderStatus.update(orderId, orderStatus);
  }
}
