package com.emhk.menu.menuapi.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emhk.menu.menuapi.domain.models.Establishment;

public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {
  List<Establishment> findByOwnerId(Long id);
}
