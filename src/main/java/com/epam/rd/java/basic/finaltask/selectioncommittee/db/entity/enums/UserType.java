package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.enums;

public enum UserType {
  ENTRANT("entrant"),ADMIN("admin");

  private String name;
  UserType(String name){
    this.name = name;
  }

  @Override
  public String toString() {
    return "UserType{" +
        "name='" + name + '\'' +
        '}';
  }
}
