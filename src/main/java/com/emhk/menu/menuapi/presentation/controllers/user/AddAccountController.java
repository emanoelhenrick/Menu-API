package com.emhk.menu.menuapi.presentation.controllers.user;

import com.emhk.menu.menuapi.domain.services.user.AddAccount;
import com.emhk.menu.menuapi.presentation.controllers.dtos.user.input.disassembler.UserDisassembler;
import com.emhk.menu.menuapi.presentation.controllers.dtos.user.output.assembler.UserAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emhk.menu.menuapi.presentation.controllers.dtos.user.input.UserInput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.user.output.UserOutput;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/singup")
public class AddAccountController {

  @Autowired
  private AddAccount addAccount;

  @Autowired
  private UserAssembler assembler;

  @Autowired
  private UserDisassembler disassembler;

  @PostMapping
  public UserOutput addNewAccount(@RequestBody @Valid UserInput input) {
    var userToSave = disassembler.toDomainModel(input);
    var user = addAccount.add(userToSave);
    return assembler.toDTO(user);
  }
  
}
