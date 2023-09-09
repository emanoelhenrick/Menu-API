package com.emhk.menu.menuapi.presentation.controllers.establishment;

import com.emhk.menu.menuapi.domain.models.User;
import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.input.disassembler.EstablishmentDisassembler;
import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.output.assembler.EstablishmentAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.input.EstablishmentInput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.output.EstablishmentOutput;
import com.emhk.menu.menuapi.domain.services.establishment.AddEstablishment;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user/{ownerUsername}/establishment")
public class AddEstablishmentController {
  
  @Autowired
  private AddEstablishment addEstablishment;

  @Autowired
  private EstablishmentDisassembler disassembler;

  @Autowired
  private EstablishmentAssembler assembler;

  @PostMapping
  public EstablishmentOutput addNewEstablishment(
    @Valid @RequestBody EstablishmentInput input, @PathVariable String ownerUsername
  ) {
    var establishmentToSave = disassembler.toDomainModel(input);
    var user = new User();
    user.setUsername(ownerUsername);
    establishmentToSave.setOwner(user);
    var establishment = addEstablishment.add(establishmentToSave);
    return assembler.toDTO(establishment);
  }

}
