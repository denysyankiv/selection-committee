package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.Entity;
import java.util.Objects;

public class FacultySubject implements Entity {
  private int id;
  private int facultyId;
  private int subjectId;

  public FacultySubject() {
  }

  public FacultySubject(int id, int facultyId, int subjectId) {
    this.id = id;
    this.facultyId = facultyId;
    this.subjectId = subjectId;
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

  public int getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(int subjectId) {
    this.subjectId = subjectId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FacultySubject that = (FacultySubject) o;
    return id == that.id && facultyId == that.facultyId
        && subjectId == that.subjectId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, facultyId, subjectId);
  }

  @Override
  public String toString() {
    return "FacultySubject{" +
        "id=" + id +
        ", facultyId=" + facultyId +
        ", subjectId=" + subjectId +
        '}';
  }
}
