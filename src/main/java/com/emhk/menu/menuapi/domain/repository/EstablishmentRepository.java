package com.emhk.menu.menuapi.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emhk.menu.menuapi.domain.models.Establishment;

public interface EstablishmentRepository extends JpaRepository<Establishment, String> {
  Optional<Establishment> findById(UUID id);
  Optional<List<Establishment>> findAllByOwnerId(UUID id);
}
