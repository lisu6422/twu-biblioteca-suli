package com.twu.biblioteca.service;

import static org.junit.Assert.assertEquals;

import com.twu.biblioteca.resource.User;
import org.junit.Test;

public class UserServiceTest {

  private UserService service = new UserService();

  @Test
  public void shouldReturnTrueWithValidUserInfoSuccess() {
    boolean result = service.validUser(new User("Judy Singh", "123456", "librarian"));
    assertEquals(true, result);
  }

  @Test
  public void shouldReturnFalseWithInValidUserInfoSuccess() {
    boolean result = service.validUser(new User("Judy Singh", "", "customer"));
    assertEquals(false, result);
  }

  @Test
  public void shouldFindUserByIdSuccess() {
    User result = service.findUserById(1L);
    assertEquals(1, result.getId().intValue());
  }
}