package com.emhk.menu.menuapi.presentation.controllers.dtos.order.input.disassembler;

import com.emhk.menu.menuapi.domain.models.Order;
import com.emhk.menu.menuapi.presentation.controllers.dtos.order.input.OrderInput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.product.input.ProductIdInput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.product.output.ProductShortOutput;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class OrderDisassembler {
	private final ModelMapper mapper;

	OrderDisassembler(ModelMapper modelMapper) {
		this.mapper = modelMapper;
	}

	public Order toDomainModel(OrderInput input) {
		return mapper.map(input, Order.class);
	}

	public void copyToDomainObject(OrderInput input, Order order) {
		mapper.map(input, order);
	}
}
