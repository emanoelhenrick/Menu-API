package com.emhk.menu.menuapi.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emhk.menu.menuapi.domain.models.Establishment;

public interface EstablishmentRepository extends JpaRepository<Establishment, String> {
  List<Establishment> findByOwnerId(String id);
}
