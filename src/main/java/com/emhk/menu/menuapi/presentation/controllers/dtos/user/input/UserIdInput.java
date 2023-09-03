package com.emhk.menu.menuapi.presentation.controllers.dtos.user.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserIdInput {

  @NotBlank
  private String id;
}
