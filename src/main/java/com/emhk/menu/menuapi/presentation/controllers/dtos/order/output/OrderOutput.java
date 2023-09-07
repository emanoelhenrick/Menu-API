package com.emhk.menu.menuapi.presentation.controllers.dtos.order.output;

import com.emhk.menu.menuapi.domain.models.OrderStatus;
import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.output.EstablishmentShortOutput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.product.output.ProductOrderOutput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.user.output.UserOutput;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
public class OrderOutput {

	private String id;
	private List<ProductOrderOutput> products;
	private BigDecimal totalPrice;
	private OrderStatus status;
	private UserOutput customer;
	private EstablishmentShortOutput establishment;
	private OffsetDateTime createdAt;

}
