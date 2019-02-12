package com.twu.biblioteca.service;

import com.twu.biblioteca.resource.BibliotecaResource;
import com.twu.biblioteca.resource.User;

public class UserService {

  private final BibliotecaResource resource = BibliotecaResource.getInstance();

  public User findUser(User user) {
    return resource.getUserList().stream().filter(item -> item.equals(user)).findFirst()
        .orElse(null);
  }

  public User findUserById(Long id) {
    return resource.getUserList().stream().filter(user -> user.getId().equals(id)).findFirst()
        .orElse(null);
  }
}
