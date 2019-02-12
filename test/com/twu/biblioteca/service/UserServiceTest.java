package com.twu.biblioteca.service;

import static org.junit.Assert.assertEquals;

import com.twu.biblioteca.resource.User;
import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {

  private UserService service = new UserService();

  @Test
  public void shouldReturnTrueWithValidUserInfoSuccess() {
    User result = service.findUser(new User("Judy Singh", "123456", "librarian"));
    Assert.assertNotEquals(null, result);
  }

  @Test
  public void shouldReturnFalseWithInValidUserInfoSuccess() {
    User result = service.findUser(new User("Judy Singh", "", "customer"));
    assertEquals(null, result);
  }

  @Test
  public void shouldFindUserByIdSuccess() {
    User result = service.findUserById(1L);
    assertEquals(1, result.getId().intValue());
  }
}