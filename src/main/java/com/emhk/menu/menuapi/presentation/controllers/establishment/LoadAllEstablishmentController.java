package com.emhk.menu.menuapi.presentation.controllers.establishment;

import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.output.assembler.EstablishmentAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
  public Page<EstablishmentShortOutput> loadAllEstablishmentByOwner(
    @PathVariable String ownerUsername, Pageable pageable
  ) {
    var establishments = loadAllEstablishment.loadAllByOwner(ownerUsername, pageable);
    var establishmentsDto = assembler.toShortDTOCollection(establishments);
    return new PageImpl<EstablishmentShortOutput>(establishmentsDto, pageable, pageable.getPageSize());
  }
  
}
