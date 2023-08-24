package com.emhk.menu.menuapi.presentation.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emhk.menu.menuapi.data.services.user.DbAddAccount;
import com.emhk.menu.menuapi.presentation.dtos.user.input.UserInput;
import com.emhk.menu.menuapi.presentation.dtos.user.input.disassembler.UserDisassembler;
import com.emhk.menu.menuapi.presentation.dtos.user.output.UserOutput;
import com.emhk.menu.menuapi.presentation.dtos.user.output.assembler.UserAssembler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/singup")
public class AddAccountController {

  @Autowired
  private DbAddAccount addAccount;

  @Autowired
  private UserDisassembler disassembler;

  @Autowired
  private UserAssembler assembler;

  @PostMapping
  public UserOutput addAccount(@RequestBody @Valid UserInput input) {
    var account = disassembler.toDomainModel(input);
    return assembler.toDTO(addAccount.add(account));
  }
  
}
