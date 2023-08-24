package com.emhk.menu.menuapi.presentation.dtos.establishment.input.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emhk.menu.menuapi.domain.models.Establishment;
import com.emhk.menu.menuapi.presentation.dtos.establishment.input.EstablishmentInput;

@Component
public class EstablishmentDisassembler {
  
  @Autowired
  private ModelMapper mapper;
  
  public Establishment toDomainModel(EstablishmentInput input) {
    return mapper.map(input, Establishment.class);
  }

  public void copyToDomainObject(EstablishmentInput input, Establishment establishment) {
    mapper.map(input, establishment);
  }

}
