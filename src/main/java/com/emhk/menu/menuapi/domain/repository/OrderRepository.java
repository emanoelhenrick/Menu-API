package com.emhk.menu.menuapi.domain.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.emhk.menu.menuapi.domain.models.Order;

public interface OrderRepository extends JpaRepository<Order, UUID> {
  List<Order> findAllByCustomerUsername(String username, Pageable pageable);
}
