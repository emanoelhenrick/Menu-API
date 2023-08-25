package com.emhk.menu.menuapi.presentation.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emhk.menu.menuapi.data.services.user.DbAddAccount;
import com.emhk.menu.menuapi.domain.services.dtos.user.input.UserInput;
import com.emhk.menu.menuapi.domain.services.dtos.user.output.UserOutput;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/singup")
public class AddAccountController {

  @Autowired
  private DbAddAccount addAccount;

  @PostMapping
  public UserOutput addNewAccount(@RequestBody @Valid UserInput input) {
    return addAccount.add(input);
  }
  
}
