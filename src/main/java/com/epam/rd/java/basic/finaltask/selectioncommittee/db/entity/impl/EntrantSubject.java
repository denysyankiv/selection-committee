package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.Entity;
import java.util.Objects;

public class EntrantSubject implements Entity {
  private int id;
  private int entrantId;
  private int subjectId;
  private float subjectMark;

  public EntrantSubject(int id, int entrantId, int subjectId,
      float subjectMark) {
    this.id = id;
    this.entrantId = entrantId;
    this.subjectId = subjectId;
    this.subjectMark = subjectMark;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getEntrantId() {
    return entrantId;
  }

  public void setEntrantId(int entrantId) {
    this.entrantId = entrantId;
  }

  public int getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(int subjectId) {
    this.subjectId = subjectId;
  }

  public float getSubjectMark() {
    return subjectMark;
  }

  public void setSubjectMark(float subjectMark) {
    this.subjectMark = subjectMark;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EntrantSubject that = (EntrantSubject) o;
    return id == that.id && entrantId == that.entrantId
        && subjectId == that.subjectId
        && Float.compare(that.subjectMark, subjectMark) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, entrantId, subjectId, subjectMark);
  }

  @Override
  public String toString() {
    return "EntrantSubject{" +
        "id=" + id +
        ", entrantId=" + entrantId +
        ", subjectId=" + subjectId +
        ", subjectMark=" + subjectMark +
        '}';
  }
}
