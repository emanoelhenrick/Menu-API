package com.emhk.menu.menuapi.data.services.establishment;

import com.emhk.menu.menuapi.domain.exceptions.user.UserNotFoundException;
import com.emhk.menu.menuapi.domain.models.Establishment;
import com.emhk.menu.menuapi.domain.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.repository.EstablishmentRepository;
import com.emhk.menu.menuapi.domain.services.establishment.LoadAllEstablishment;

import java.util.List;

@Service
public class DbLoadAllEstablishment implements LoadAllEstablishment {

  private final EstablishmentRepository establishmentRepository;
  private final UserRepository userRepository;

  DbLoadAllEstablishment(EstablishmentRepository establishmentRepository, UserRepository userRepository) {
    this.establishmentRepository = establishmentRepository;
    this.userRepository = userRepository;
  }

  @Override
  public List<Establishment> loadAllByOwner(String username, Pageable pageable) {
    userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
		return establishmentRepository.findAllByOwnerUsername(username, pageable);
  }
  
}
