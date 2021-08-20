package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity;

public class Language implements Entity{
  private int id;
  private String name;

  @Override
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
