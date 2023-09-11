package com.emhk.menu.menuapi.domain.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.emhk.menu.menuapi.domain.models.Establishment;

public interface EstablishmentRepository extends JpaRepository<Establishment, UUID> {
  Page<Establishment> findAllByOwnerUsername(String username, Pageable pageable);
}
