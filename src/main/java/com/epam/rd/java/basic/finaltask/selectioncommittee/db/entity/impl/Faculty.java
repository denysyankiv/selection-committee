package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.Entity;
import java.util.Objects;

public class Faculty implements Entity {

  private int id;
  private int finByGovNumOfStudents;
  private int commercialStudents;


  public void setId(int id) {
    this.id = id;
  }

  public int getFinByGovNumOfStudents() {
    return finByGovNumOfStudents;
  }

  public void setFinByGovNumOfStudents(int finByGovNumOfStudents) {
    this.finByGovNumOfStudents = finByGovNumOfStudents;
  }

  public int getCommercialStudents() {
    return commercialStudents;
  }

  public void setCommercialStudents(int commercialStudents) {
    this.commercialStudents = commercialStudents;
  }

  public Faculty() {

  }

  public Faculty(int id, int finByGovNumOfStudents, int commercialStudents) {
    this.id = id;
    this.finByGovNumOfStudents = finByGovNumOfStudents;
    this.commercialStudents = commercialStudents;
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Faculty faculty = (Faculty) o;
    return id == faculty.id
        && finByGovNumOfStudents == faculty.finByGovNumOfStudents
        && commercialStudents == faculty.commercialStudents;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, finByGovNumOfStudents, commercialStudents);
  }

  @Override
  public String toString() {
    return "Faculty{" +
        "id=" + id +
        ", finByGovNumOfStudents=" + finByGovNumOfStudents +
        ", commercialStudents=" + commercialStudents +
        '}';
  }
}
