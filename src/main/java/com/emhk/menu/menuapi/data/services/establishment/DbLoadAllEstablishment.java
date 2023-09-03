package com.emhk.menu.menuapi.data.services.establishment;

import java.util.List;
import java.util.UUID;

import com.emhk.menu.menuapi.domain.exceptions.user.UserNotFoundException;
import com.emhk.menu.menuapi.domain.models.Establishment;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.repository.EstablishmentRepository;
import com.emhk.menu.menuapi.domain.services.establishment.LoadAllEstablishment;

@Service
public class DbLoadAllEstablishment implements LoadAllEstablishment {

  private final EstablishmentRepository establishmentRepository;

  DbLoadAllEstablishment(EstablishmentRepository establishmentRepository) {
    this.establishmentRepository = establishmentRepository;
  }

  @Override
  public List<Establishment> loadAllByOwner(String id) {
		return establishmentRepository
      .findAllByOwnerId(UUID.fromString(id))
      .orElseThrow(() -> new UserNotFoundException(id));
  }
  
}
