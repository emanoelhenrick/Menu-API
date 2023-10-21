package com.emhk.menu.menuapi.domain.repository;

import java.util.List;
import java.util.UUID;

import com.emhk.menu.menuapi.domain.models.OrderStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.emhk.menu.menuapi.domain.models.Order;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, UUID> {
  List<Order> findAllByCustomerUsername(String username, Pageable pageable);
  @Query("from Order where order.establishment.id = :establishmentId and order.status = :status")
  List<Order> findAllbyStatus(UUID establishmentId, OrderStatus status);
}
