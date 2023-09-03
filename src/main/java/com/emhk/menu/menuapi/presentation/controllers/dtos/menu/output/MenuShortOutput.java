package com.emhk.menu.menuapi.presentation.controllers.dtos.menu.output;

import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.output.EstablishmentShortOutput;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuShortOutput {

  private String id;
  private String name;
  private EstablishmentShortOutput establishment;

}
