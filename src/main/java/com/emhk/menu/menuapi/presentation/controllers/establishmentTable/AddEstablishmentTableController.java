package com.emhk.menu.menuapi.presentation.controllers.establishmentTable;

import com.emhk.menu.menuapi.domain.services.establishmentTable.AddEstablishmentTable;
import com.emhk.menu.menuapi.presentation.controllers.dtos.establishmentTable.input.EstablishmentTableInput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.establishmentTable.input.disassembler.EstablishmentTableDisassembler;
import com.emhk.menu.menuapi.presentation.controllers.dtos.establishmentTable.output.EstablishmentTableOutput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.establishmentTable.output.assembler.EstablishmentTableAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/establishment/{establishmentId}/tables")
public class AddEstablishmentTableController {

  @Autowired
  private AddEstablishmentTable addEstablishmentTable;

  @Autowired
  private EstablishmentTableDisassembler disassembler;

  @Autowired
  private EstablishmentTableAssembler assembler;

  @PostMapping
  public EstablishmentTableOutput addTable(
    @PathVariable String establishmentId,
    @RequestBody EstablishmentTableInput establishmentTableInput
  ) {
    var tableToSave = disassembler.toDomainModel(establishmentTableInput);
    var savedTable = addEstablishmentTable.add(tableToSave, establishmentId);
    return assembler.toDTO(savedTable);
  }

}
