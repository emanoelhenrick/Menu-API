package com.emhk.menu.menuapi.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emhk.menu.menuapi.domain.models.User;

public interface UserRepository extends JpaRepository<User, UUID> {
  public Optional<User> findByUsername(String username);
}
