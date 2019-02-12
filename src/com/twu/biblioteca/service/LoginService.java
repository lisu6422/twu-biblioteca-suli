package com.twu.biblioteca.service;

import com.twu.biblioteca.resource.BibliotecaResource;
import com.twu.biblioteca.resource.User;

public class LoginService {

  private final BibliotecaResource resource = BibliotecaResource.getInstance();

  public boolean login(User user) {
    return resource.getUserList().stream().filter(item -> item.equals(user)).findFirst()
        .isPresent();
  }
}
