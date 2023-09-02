package com.emhk.menu.menuapi.data.services.establishment;

import java.util.UUID;

import com.emhk.menu.menuapi.domain.exceptions.BusinessException;
import com.emhk.menu.menuapi.domain.exceptions.establishment.AccessDeniedException;
import com.emhk.menu.menuapi.domain.exceptions.user.UserNotFoundException;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.models.UserRole;
import com.emhk.menu.menuapi.domain.repository.EstablishmentRepository;
import com.emhk.menu.menuapi.domain.repository.UserRepository;
import com.emhk.menu.menuapi.domain.services.dtos.establishment.input.EstablishmentInput;
import com.emhk.menu.menuapi.domain.services.dtos.establishment.input.disassembler.EstablishmentDisassembler;
import com.emhk.menu.menuapi.domain.services.dtos.establishment.output.EstablishmentOutput;
import com.emhk.menu.menuapi.domain.services.dtos.establishment.output.assembler.EstablishmentAssembler;
import com.emhk.menu.menuapi.domain.services.establishment.AddEstablishment;

@Service
public class DbAddEstablishment implements AddEstablishment {

  private final EstablishmentRepository establishmentRepository;
  private final UserRepository userRepository;
  private final EstablishmentAssembler assembler;
  private final EstablishmentDisassembler disassembler;

  DbAddEstablishment (
    EstablishmentRepository establishmentRepository,
    UserRepository userRepository,
    EstablishmentAssembler assembler,
    EstablishmentDisassembler disassembler
  ) {
    this.assembler = assembler;
    this.disassembler = disassembler;
    this.establishmentRepository = establishmentRepository;
    this.userRepository = userRepository;
  }

  @Override
  public EstablishmentOutput add(EstablishmentInput input) {
    var ownerId = UUID.fromString(input.getOwner().getId());
    var owner = userRepository.findById(ownerId)
      .orElseThrow(() -> new UserNotFoundException(input.getOwner().getId()));
    if (owner.getRole() != UserRole.OWNER) {
      throw new AccessDeniedException();
    }
    var establishment = disassembler.toDomainModel(input);
    var saved = establishmentRepository.save(establishment);
    return assembler.toDTO(saved);
  }
  
}
