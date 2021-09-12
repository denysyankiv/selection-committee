package com.epam.rd.java.basic.finaltask.selectioncommittee.dto;

public class FacultyDTO {
  private int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  private int finByGovNumOfStudents;
  private int commercialStudents;
  private String name;
  private String description;

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
  public String toString() {
    return "FacultyDTO{" +
        "id=" + id +
        ", finByGovNumOfStudents=" + finByGovNumOfStudents +
        ", commercialStudents=" + commercialStudents +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
