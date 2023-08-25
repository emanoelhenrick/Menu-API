package com.emhk.menu.menuapi.domain.services.user;

import com.emhk.menu.menuapi.domain.services.dtos.user.input.UserInput;
import com.emhk.menu.menuapi.domain.services.dtos.user.output.UserOutput;

public interface AddAccount {
  public UserOutput add(UserInput user);
}
