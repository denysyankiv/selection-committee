package com.epam.rd.java.basic.finaltask.selectioncommittee.dto;

import java.util.Objects;

public class SubjectDTO {

  private int id;
  private String name;
  private String subjectType;

  public SubjectDTO(int id, String name, String subjectType) {
    this.id = id;
    this.name = name;
    this.subjectType = subjectType;
  }

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

  public String getSubjectType() {
    return subjectType;
  }

  public void setSubjectType(String subjectType) {
    this.subjectType = subjectType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubjectDTO that = (SubjectDTO) o;
    return id == that.id && Objects.equals(name, that.name)
        && Objects.equals(subjectType, that.subjectType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, subjectType);
  }

  @Override
  public String toString() {
    return "SubjectDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", subjectType='" + subjectType + '\'' +
        '}';
  }
}
