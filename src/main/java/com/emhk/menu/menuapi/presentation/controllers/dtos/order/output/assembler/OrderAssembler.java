package com.emhk.menu.menuapi.presentation.controllers.dtos.order.output.assembler;

import com.emhk.menu.menuapi.domain.models.Order;
import com.emhk.menu.menuapi.presentation.controllers.dtos.order.output.OrderOutput;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderAssembler {

	private final ModelMapper mapper;

	OrderAssembler(ModelMapper modelMapper) {
		this.mapper = modelMapper;
	}

	public OrderOutput toDTO(Order order) {
		return mapper.map(order, OrderOutput.class);
	}

	public List<OrderOutput> toDTOCollection(List<Order> orders) {
		return orders.stream()
			.map(this::toDTO)
			.toList();
	}
}
