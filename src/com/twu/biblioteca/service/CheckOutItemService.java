package com.twu.biblioteca.service;

import com.twu.biblioteca.resource.BibliotecaResource;
import com.twu.biblioteca.resource.User;
import java.util.List;
import java.util.stream.Collectors;

public class CheckOutItemService {

  private final BibliotecaResource resource = BibliotecaResource.getInstance();
  private UserService userService = new UserService();

  public List<User> findAllUsersInCheckOutItem() {
    return resource.getCheckoutItemList().stream()
        .map(item -> userService.findUserById(item.getUserId())).collect(
            Collectors.toList());
  }
}
