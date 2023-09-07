package com.emhk.menu.menuapi.presentation.controllers.dtos.user.input;

import com.emhk.menu.menuapi.core.validation.EnumValidator;
import com.emhk.menu.menuapi.domain.models.UserRole;
import jakarta.validation.constraints.Email;
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
  @Email
  private String email;

  @NotBlank
  private String password;

  @EnumValidator(
    enumClazz = UserRole.class,
    message = "must enter a valid user role"
  )
  private String role;

}
