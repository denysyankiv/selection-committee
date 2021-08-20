package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity;

public class EntrantApplication implements Entity{

  private int id;
  private Entrant entrant;
  private Faculty faculty;
  @Override
  public int getId() {
    return id;
  }
}
