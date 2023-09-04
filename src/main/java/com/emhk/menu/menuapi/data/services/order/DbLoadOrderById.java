package com.emhk.menu.menuapi.data.services.order;

import com.emhk.menu.menuapi.domain.exceptions.Order.OrderNotFoundException;
import com.emhk.menu.menuapi.domain.models.Order;
import com.emhk.menu.menuapi.domain.repository.OrderRepository;
import com.emhk.menu.menuapi.domain.services.order.LoadOrderById;

import java.util.UUID;

public class DbLoadOrderById implements LoadOrderById {

	private final OrderRepository orderRepository;

	DbLoadOrderById(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public Order load(String id) {
		return orderRepository
			.findById(UUID.fromString(id))
			.orElseThrow(() -> new OrderNotFoundException(id));
	}

}
