package com.emhk.menu.menuapi.data.services.establishment;

import java.util.UUID;

import com.emhk.menu.menuapi.domain.exceptions.establishment.EstablishmentNotFoundException;
import com.emhk.menu.menuapi.domain.models.Establishment;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.repository.EstablishmentRepository;
import com.emhk.menu.menuapi.domain.services.establishment.LoadEstablishment;

@Service
public class DbLoadEstablishment implements LoadEstablishment{

  private final EstablishmentRepository establishmentRepository;

  DbLoadEstablishment(EstablishmentRepository establishmentRepository) {
    this.establishmentRepository = establishmentRepository;
  }

  @Override
  public Establishment load(String id) {
    return establishmentRepository
        .findById(UUID.fromString(id))
        .orElseThrow(() -> new EstablishmentNotFoundException(id));
  }
  
}
