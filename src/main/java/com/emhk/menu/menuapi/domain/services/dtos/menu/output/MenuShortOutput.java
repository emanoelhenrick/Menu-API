package com.emhk.menu.menuapi.domain.services.dtos.menu.output;

import com.emhk.menu.menuapi.domain.services.dtos.establishment.output.EstablishmentShortOutput;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuShortOutput {

  private String id;
  private String name;
  private EstablishmentShortOutput establishment;

}
