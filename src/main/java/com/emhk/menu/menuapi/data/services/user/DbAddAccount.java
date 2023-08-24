package com.emhk.menu.menuapi.data.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.models.User;
import com.emhk.menu.menuapi.domain.repository.UserRepository;
import com.emhk.menu.menuapi.domain.services.user.AddAccount;

@Service
public class DbAddAccount implements AddAccount {

  @Autowired
  private UserRepository repository;

  @Override
  public User add(User user) {
    return repository.save(user);
  }
  
}
