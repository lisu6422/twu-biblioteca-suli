package com.twu.biblioteca.service;

import static org.junit.Assert.assertEquals;

import com.twu.biblioteca.resource.User;
import java.util.List;
import org.junit.Test;

public class CheckOutItemServiceTest {

  private CheckOutItemService service = new CheckOutItemService();

  @Test
  public void shouldFindAllUsersInCheckOutItemSuccess() {
    List<User> result = service.findAllUsersInCheckOutItem();
    assertEquals(1, result.size());
  }
}