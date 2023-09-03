package com.emhk.menu.menuapi.data.services.user;

import com.emhk.menu.menuapi.domain.models.User;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.repository.UserRepository;
import com.emhk.menu.menuapi.domain.services.user.AddAccount;

@Service
public class DbAddAccount implements AddAccount {

  private final UserRepository userRepository;

  DbAddAccount(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User add(User user) {
    return userRepository.save(user);
  }
  
}
