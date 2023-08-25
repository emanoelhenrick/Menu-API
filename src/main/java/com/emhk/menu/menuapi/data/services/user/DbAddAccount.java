package com.emhk.menu.menuapi.data.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.repository.UserRepository;
import com.emhk.menu.menuapi.domain.services.dtos.user.input.UserInput;
import com.emhk.menu.menuapi.domain.services.dtos.user.input.disassembler.UserDisassembler;
import com.emhk.menu.menuapi.domain.services.dtos.user.output.UserOutput;
import com.emhk.menu.menuapi.domain.services.dtos.user.output.assembler.UserAssembler;
import com.emhk.menu.menuapi.domain.services.user.AddAccount;

@Service
public class DbAddAccount implements AddAccount {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserDisassembler disassembler;

  @Autowired
  private UserAssembler assembler;

  @Override
  public UserOutput add(UserInput input) {
    var user = disassembler.toDomainModel(input);
    return assembler.toDTO(userRepository.save(user));
  }
  
}
