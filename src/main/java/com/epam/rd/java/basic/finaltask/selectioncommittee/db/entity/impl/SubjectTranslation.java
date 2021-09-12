package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.Entity;
import java.util.Objects;

public class SubjectTranslation implements Entity {
  private int id;
  private String name;
  private int subjectId;
  private int languageId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(int subjectId) {
    this.subjectId = subjectId;
  }

  public int getLanguageId() {
    return languageId;
  }

  public void setLanguageId(int languageId) {
    this.languageId = languageId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubjectTranslation that = (SubjectTranslation) o;
    return id == that.id && subjectId == that.subjectId
        && languageId == that.languageId && Objects.equals(name,
        that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, subjectId, languageId);
  }

  @Override
  public String toString() {
    return "SubjectTranslation{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", subjectId=" + subjectId +
        ", languageId=" + languageId +
        '}';
  }
}
