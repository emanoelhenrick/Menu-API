package com.emhk.menu.menuapi.domain.services.order;

import com.emhk.menu.menuapi.domain.models.Order;

public interface LoadOrderById {
	public Order load(String id);
}
