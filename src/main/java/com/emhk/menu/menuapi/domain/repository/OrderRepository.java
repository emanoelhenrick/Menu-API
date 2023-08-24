package com.emhk.menu.menuapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emhk.menu.menuapi.domain.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
  Order findByExternalId(String uuid);
}
