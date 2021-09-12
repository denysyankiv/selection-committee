package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.Entity;
import java.util.Objects;

public class FacultyTranslation implements Entity {
  private int id;
  private int facultyId;
  private int languageId;
  private String name;
  private String description;

  public FacultyTranslation(int facultyId, int languageId,
      String name, String description) {
    this.facultyId = facultyId;
    this.languageId = languageId;
    this.name = name;
    this.description = description;
  }

  public FacultyTranslation(int id, int facultyId, int languageId,
      String name, String description) {
    this.id = id;
    this.facultyId = facultyId;
    this.languageId = languageId;
    this.name = name;
    this.description = description;
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

  public int getLanguageId() {
    return languageId;
  }

  public void setLanguageId(int languageId) {
    this.languageId = languageId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FacultyTranslation that = (FacultyTranslation) o;
    return id == that.id && facultyId == that.facultyId
        && languageId == that.languageId && Objects.equals(name,
        that.name) && Objects.equals(description, that.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, facultyId, languageId, name, description);
  }

  @Override
  public String toString() {
    return "FacultyTranslation{" +
        "id=" + id +
        ", facultyId=" + facultyId +
        ", languageId=" + languageId +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
