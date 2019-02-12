package com.twu.biblioteca.service;

import com.twu.biblioteca.resource.BibliotecaResource;
import com.twu.biblioteca.resource.User;

public class UserService {

  private final BibliotecaResource resource = BibliotecaResource.getInstance();

  public boolean validUser(User user) {
    return resource.getUserList().stream().filter(item -> item.equals(user)).findFirst()
        .isPresent();
  }

  public User findUserById(Long id) {
    return resource.getUserList().stream().filter(user -> user.getId().equals(id)).findFirst()
        .orElse(null);
  }
}
