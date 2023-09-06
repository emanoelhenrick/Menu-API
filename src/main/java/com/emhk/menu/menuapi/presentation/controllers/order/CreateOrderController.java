package com.emhk.menu.menuapi.presentation.controllers.order;

import com.emhk.menu.menuapi.domain.models.Establishment;
import com.emhk.menu.menuapi.domain.models.Order;
import com.emhk.menu.menuapi.domain.services.order.CreateOrder;
import com.emhk.menu.menuapi.presentation.controllers.dtos.order.input.OrderInput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.order.input.disassembler.OrderDisassembler;
import com.emhk.menu.menuapi.presentation.controllers.dtos.order.output.OrderOutput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.order.output.assembler.OrderAssembler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/establishment/{establishmentId}/orders")
public class CreateOrderController {

	@Autowired
	private CreateOrder createOrder;

	@Autowired
	private OrderDisassembler disassembler;

	@Autowired
	private OrderAssembler assembler;

	@PostMapping
	public OrderOutput createOrder(@PathVariable String establishmentId, @Valid @RequestBody OrderInput orderInput) {
		var orderToSave = disassembler.toDomainModel(orderInput);
		Order order = createOrder.create(establishmentId, orderToSave);
		return assembler.toDTO(order);
	}

}
