package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity;

public class Entrant implements Entity {
  private int id;
  private String fullName;
  private String email;
  private String city;
  private String region;
  private String schoolName;

  @Override
  public int getId() {
    return id;
  }
}
