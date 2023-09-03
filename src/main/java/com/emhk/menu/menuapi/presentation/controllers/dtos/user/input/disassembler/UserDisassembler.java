package com.emhk.menu.menuapi.presentation.controllers.dtos.user.input.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.emhk.menu.menuapi.domain.models.User;
import com.emhk.menu.menuapi.presentation.controllers.dtos.user.input.UserInput;

@Component
public class UserDisassembler {

  private final ModelMapper mapper;

  UserDisassembler(ModelMapper modelMapper) {
    this.mapper = modelMapper;
  }
  
  public User toDomainModel(UserInput input) {
    return mapper.map(input, User.class);
  }

  public void copyToDomainObject(UserInput input, User user) {
    mapper.map(input, user);
  }

}
