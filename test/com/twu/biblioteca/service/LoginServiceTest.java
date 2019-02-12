package com.twu.biblioteca.service;

import static org.junit.Assert.assertEquals;

import com.twu.biblioteca.resource.User;
import org.junit.Test;

public class LoginServiceTest {

  private LoginService service = new LoginService();

  @Test
  public void shouldLoginWithValidUserInfoSuccess() {
    boolean result = service.login(new User("Judy Singh", "123456", "customer"));
    assertEquals(true, result);
  }

  @Test
  public void shouldLoginWithInValidUserInfoFailed() {
    boolean result = service.login(new User("Judy Singh", "", "customer"));
    assertEquals(false, result);
  }
}