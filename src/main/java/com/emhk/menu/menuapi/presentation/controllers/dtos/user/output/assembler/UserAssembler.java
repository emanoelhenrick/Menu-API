package com.emhk.menu.menuapi.presentation.controllers.dtos.user.output.assembler;

import java.util.List;

import com.emhk.menu.menuapi.presentation.controllers.dtos.user.output.UserOutput;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.emhk.menu.menuapi.domain.models.User;

@Component
public class UserAssembler {

  private final ModelMapper mapper;

  UserAssembler(ModelMapper modelMapper) {
    this.mapper = modelMapper;
  }
  
  public UserOutput toDTO(User User) {
    return mapper.map(User, UserOutput.class);
  }

  public List<UserOutput> toDTOCollection(List<User> Users) {
    return Users.stream()
      .map(User -> toDTO(User))
      .toList();
  }
}
