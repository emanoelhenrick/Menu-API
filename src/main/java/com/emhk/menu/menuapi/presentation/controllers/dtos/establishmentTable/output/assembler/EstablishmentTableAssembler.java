package com.emhk.menu.menuapi.presentation.controllers.dtos.establishmentTable.output.assembler;

import com.emhk.menu.menuapi.domain.models.EstablishmentTable;
import com.emhk.menu.menuapi.presentation.controllers.dtos.establishmentTable.output.EstablishmentTableOutput;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstablishmentTableAssembler {
  private final ModelMapper mapper;

  public EstablishmentTableAssembler(ModelMapper modelMapper) {
    this.mapper = modelMapper;
  }

  public EstablishmentTableOutput toDTO(EstablishmentTable establishmentTable) {
    return mapper.map(establishmentTable, EstablishmentTableOutput.class);
  }

  public List<EstablishmentTableOutput> toDTOCollection(List<EstablishmentTable> establishmentTables) {
    return establishmentTables.stream()
      .map(table -> toDTO(table))
      .toList();
  }
}
