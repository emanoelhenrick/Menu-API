package com.emhk.menu.menuapi.data.services.establishment;

import com.emhk.menu.menuapi.domain.exceptions.establishment.AccessDeniedException;
import com.emhk.menu.menuapi.domain.exceptions.user.UserNotFoundException;
import com.emhk.menu.menuapi.domain.models.Establishment;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.models.UserRole;
import com.emhk.menu.menuapi.domain.repository.EstablishmentRepository;
import com.emhk.menu.menuapi.domain.repository.UserRepository;
import com.emhk.menu.menuapi.domain.services.establishment.AddEstablishment;

@Service
public class DbAddEstablishment implements AddEstablishment {

  private final EstablishmentRepository establishmentRepository;
  private final UserRepository userRepository;

  DbAddEstablishment (
    EstablishmentRepository establishmentRepository,
    UserRepository userRepository
  ) {
    this.establishmentRepository = establishmentRepository;
    this.userRepository = userRepository;
  }

  @Override
  public Establishment add(Establishment establishment) {
    var ownerUsername = establishment.getOwner().getUsername();
    var owner = userRepository.findByUsername(ownerUsername)
      .orElseThrow(() -> new UserNotFoundException(ownerUsername));
    if (owner.getRole() != UserRole.OWNER) throw new AccessDeniedException();
    establishment.setOwner(owner);
    return establishmentRepository.save(establishment);
  }
  
}
