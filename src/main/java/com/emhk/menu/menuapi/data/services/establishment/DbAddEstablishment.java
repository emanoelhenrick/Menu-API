package com.emhk.menu.menuapi.data.services.establishment;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private EstablishmentRepository establishmentRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private EstablishmentAssembler assembler;

  @Autowired
  private EstablishmentDisassembler disassembler;

  @Override
  public EstablishmentOutput add(EstablishmentInput input) {
    var ownerId = UUID.fromString(input.getOwner().getId());
    var owner = userRepository.findById(ownerId).orElseThrow();
    
    if (owner.getRole() != UserRole.OWNER) throw new RuntimeException();

    var establishment = disassembler.toDomainModel(input);
    return assembler.toDTO(establishmentRepository.save(establishment));
  }
  
}
