package com.emhk.menu.menuapi.presentation.controllers.dtos.address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressOutput {
  
  private String cep;
  private String district;
  private String number;
  private String city;
  private String State;
  private String complement;

}
