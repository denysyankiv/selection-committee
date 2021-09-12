package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.Entity;
import java.util.Objects;

public class User implements Entity {
  private int id;
  private String login;
  private String password;
  private String type;

  public User(int id, String login, String password, String type) {
    this.id = id;
    this.login = login;
    this.password = password;
    this.type = type;
  }

  public int getId() {
    return 0;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
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
    return id == user.id && Objects.equals(login, user.login)
        && Objects.equals(password, user.password)
        && Objects.equals(type, user.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, login, password, type);
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", login='" + login + '\'' +
        ", password='" + password + '\'' +
        ", type='" + type + '\'' +
        '}';
  }
}
