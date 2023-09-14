package com.emhk.menu.menuapi.presentation.controllers.dtos.order.input;

import com.emhk.menu.menuapi.config.validation.EnumValidator;
import com.emhk.menu.menuapi.domain.models.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderStatusInput {

  @EnumValidator(
    enumClazz = OrderStatus.class,
    message = "must enter a valid status"
  )
  private String status;

}
