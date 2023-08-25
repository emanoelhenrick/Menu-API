package com.emhk.menu.menuapi.data.services.user;

import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.repository.UserRepository;
import com.emhk.menu.menuapi.domain.services.dtos.user.input.UserInput;
import com.emhk.menu.menuapi.domain.services.dtos.user.input.disassembler.UserDisassembler;
import com.emhk.menu.menuapi.domain.services.dtos.user.output.UserOutput;
import com.emhk.menu.menuapi.domain.services.dtos.user.output.assembler.UserAssembler;
import com.emhk.menu.menuapi.domain.services.user.AddAccount;

@Service
public class DbAddAccount implements AddAccount {

  private final UserRepository userRepository;
  private final UserDisassembler disassembler;
  private final UserAssembler assembler;

  DbAddAccount(
    UserRepository userRepository,
    UserDisassembler disassembler,
    UserAssembler assembler
  ) {
    this.userRepository = userRepository;
    this.disassembler = disassembler;
    this.assembler = assembler;
  }

  @Override
  public UserOutput add(UserInput input) {
    var newUser = disassembler.toDomainModel(input);
    var user = userRepository.save(newUser);
    return assembler.toDTO(user);
  }
  
}
