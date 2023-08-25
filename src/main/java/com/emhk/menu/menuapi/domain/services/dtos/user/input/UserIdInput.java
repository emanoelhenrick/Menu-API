package com.emhk.menu.menuapi.domain.services.dtos.user.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserIdInput {

  @NotBlank
  private String id;
}
