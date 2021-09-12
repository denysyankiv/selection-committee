package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.Entity;
import java.util.Objects;

public class Acceptance implements Entity {
  private int id;
  private int facultyId;
  private int entrantId;
  private boolean isFinal;

  public Acceptance(int id, int facultyId, int entrantId, boolean isFinal) {
    this.id = id;
    this.facultyId = facultyId;
    this.entrantId = entrantId;
    this.isFinal = isFinal;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getFacultyId() {
    return facultyId;
  }

  public void setFacultyId(int facultyId) {
    this.facultyId = facultyId;
  }

  public int getEntrantId() {
    return entrantId;
  }

  public void setEntrantId(int entrantId) {
    this.entrantId = entrantId;
  }

  public boolean isFinal() {
    return isFinal;
  }

  public void setFinal(boolean aFinal) {
    isFinal = aFinal;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Acceptance that = (Acceptance) o;
    return id == that.id && facultyId == that.facultyId
        && entrantId == that.entrantId && isFinal == that.isFinal;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, facultyId, entrantId, isFinal);
  }

  @Override
  public String toString() {
    return "Acceptance{" +
        "id=" + id +
        ", facultyId=" + facultyId +
        ", entrantId=" + entrantId +
        ", isFinal=" + isFinal +
        '}';
  }
}
