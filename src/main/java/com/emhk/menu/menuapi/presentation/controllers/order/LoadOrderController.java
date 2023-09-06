package com.emhk.menu.menuapi.presentation.controllers.order;

import com.emhk.menu.menuapi.domain.services.order.LoadOrderById;
import com.emhk.menu.menuapi.presentation.controllers.dtos.order.output.OrderOutput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.order.output.assembler.OrderAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders/{id}")
public class LoadOrderController {

	@Autowired
	private LoadOrderById loadOrderById;

	@Autowired
	private OrderAssembler assembler;

	@GetMapping
	public OrderOutput createOrder(@PathVariable String id) {
		var order = loadOrderById.load(id);
		return assembler.toDTO(order);
	}

}
