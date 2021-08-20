package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity;

import java.util.Map;

public class FacultyExams implements Entity{
  private int id;
  private Faculty faculty;
  private Subject subject1;
  private Subject subject2;
  private Subject subject3;
  private Subject subject4;
  @Override
  public int getId() {
    return 0;
  }
}
