package com.emhk.menu.menuapi.presentation.dtos.user.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInput {

  @NotBlank
  private String name;

  @NotBlank
  private String username;

  @NotBlank
  private String email;

  @NotBlank
  private String password;

  @NotBlank
  private String role;

}
