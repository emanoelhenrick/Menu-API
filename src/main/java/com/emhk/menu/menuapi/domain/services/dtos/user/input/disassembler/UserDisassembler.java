package com.emhk.menu.menuapi.domain.services.dtos.user.input.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emhk.menu.menuapi.domain.models.User;
import com.emhk.menu.menuapi.domain.services.dtos.user.input.UserInput;

@Component
public class UserDisassembler {
  
  @Autowired
  private ModelMapper mapper;
  
  public User toDomainModel(UserInput input) {
    return mapper.map(input, User.class);
  }

  public void copyToDomainObject(UserInput input, User user) {
    mapper.map(input, user);
  }

}
