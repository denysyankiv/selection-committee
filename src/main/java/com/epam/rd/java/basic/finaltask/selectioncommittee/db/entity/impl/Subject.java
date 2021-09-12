package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.Entity;
import java.util.Objects;

public class Subject implements Entity {
  private int id;
  private int subjectTypeId;

  public Subject(int id, int subjectTypeId) {
    this.id = id;
    this.subjectTypeId = subjectTypeId;
  }

  public Subject() {

  }

  public int getId(){
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public int getSubjectTypeId() {
    return subjectTypeId;
  }

  public void setSubjectTypeId(int subjectTypeId) {
    this.subjectTypeId = subjectTypeId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Subject subject = (Subject) o;
    return id == subject.id && subjectTypeId == subject.subjectTypeId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, subjectTypeId);
  }

  @Override
  public String toString() {
    return "Subject{" +
        "id=" + id +
        ", subjectTypeId=" + subjectTypeId +
        '}';
  }
}
