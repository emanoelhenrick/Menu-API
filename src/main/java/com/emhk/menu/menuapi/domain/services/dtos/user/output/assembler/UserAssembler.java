package com.emhk.menu.menuapi.domain.services.dtos.user.output.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emhk.menu.menuapi.domain.models.User;
import com.emhk.menu.menuapi.domain.services.dtos.user.output.UserOutput;

@Component

public class UserAssembler {

  @Autowired
  private ModelMapper mapper;
  
  public UserOutput toDTO(User User) {
    return mapper.map(User, UserOutput.class);
  }

  public List<UserOutput> toDTOCollection(List<User> Users) {
    return Users.stream()
      .map(User -> toDTO(User))
      .toList();
  }
}
