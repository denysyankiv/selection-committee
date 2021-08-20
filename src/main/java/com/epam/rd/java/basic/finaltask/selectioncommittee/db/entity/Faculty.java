package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity;

public class Faculty implements Entity {

  private int id;
  private int finByGovNumOfStudents;
  private int overallNumOfStudents;

  public Faculty() {

  }

  public Faculty(int id, int finByGovNumOfStudents,
      int overallNumOfStudents) {
    this.id = id;
    this.finByGovNumOfStudents = finByGovNumOfStudents;
    this.overallNumOfStudents = overallNumOfStudents;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Faculty{" +
        "id=" + id +
        ", finByGovNumOfStudents=" + finByGovNumOfStudents +
        ", overallNumOfStudents=" + overallNumOfStudents +
        '}';
  }
}
