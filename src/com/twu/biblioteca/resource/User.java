package com.twu.biblioteca.resource;

import java.util.Objects;

public class User {

  private Long id;
  private String userName;
  private String password;
  private String type;

  public User(Long id, String userName, String password, String type) {
    this.id = id;
    this.userName = userName;
    this.password = password;
    this.type = type;
  }

  public User(String userName, String password, String type) {
    this.userName = userName;
    this.password = password;
    this.type = type;
  }

  public Long getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }

  public String getType() {
    return type;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "id=" + id +
        ", userName='" + userName + '\'' +
        ", password='" + password + '\'' +
        ", type='" + type + '\'' + '\n';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(userName, user.userName) &&
        Objects.equals(password, user.password) &&
        Objects.equals(type, user.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName, password, type);
  }
}
