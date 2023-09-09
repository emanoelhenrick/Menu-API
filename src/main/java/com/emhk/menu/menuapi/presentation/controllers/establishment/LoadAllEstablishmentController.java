package com.emhk.menu.menuapi.presentation.controllers.establishment;

import java.util.List;

import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.input.disassembler.EstablishmentDisassembler;
import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.output.assembler.EstablishmentAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.output.EstablishmentShortOutput;
import com.emhk.menu.menuapi.domain.services.establishment.LoadAllEstablishment;

@RestController
@RequestMapping("/user/{ownerUsername}/establishment")
public class LoadAllEstablishmentController {

  @Autowired
  private LoadAllEstablishment loadAllEstablishment;

  @Autowired
  private EstablishmentAssembler assembler;

  @GetMapping
  public List<EstablishmentShortOutput> loadAllEstablishmentByOwner(@PathVariable String ownerUsername) {
    var establishments = loadAllEstablishment.loadAllByOwner(ownerUsername);
    return assembler.toShortDTOCollection(establishments);
  }
  
}
