package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity;

public class Subject implements Entity{
  private int id;
  private String name;
  @Override
  public int getId(){
    return id;
  }
}
