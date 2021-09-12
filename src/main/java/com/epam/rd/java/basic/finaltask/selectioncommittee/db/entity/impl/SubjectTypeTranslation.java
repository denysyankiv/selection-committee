package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.Entity;
import java.util.Objects;

public class SubjectTypeTranslation implements Entity {
  private int id;
  private String name;
  private int subjectTypeId;
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

  public int getSubjectTypeId() {
    return subjectTypeId;
  }

  public void setSubjectTypeId(int subjectTypeId) {
    this.subjectTypeId = subjectTypeId;
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
    SubjectTypeTranslation that = (SubjectTypeTranslation) o;
    return id == that.id && subjectTypeId == that.subjectTypeId
        && languageId == that.languageId && Objects.equals(name,
        that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, subjectTypeId, languageId);
  }

  @Override
  public String toString() {
    return "SubjectTypeTranslation{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", subjectTypeId=" + subjectTypeId +
        ", languageId=" + languageId +
        '}';
  }
}
