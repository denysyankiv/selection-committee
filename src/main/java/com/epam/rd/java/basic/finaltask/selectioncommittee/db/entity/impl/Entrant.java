package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.Entity;
import java.util.Objects;

public class Entrant implements Entity {

  private int id;
  private String fullName;
  private String email;
  private String city;
  private String region;
  private String schoolName;
  private int stateId;
  private int userId;


  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getSchoolName() {
    return schoolName;
  }

  public void setSchoolName(String schoolName) {
    this.schoolName = schoolName;
  }

  public int getStateId() {
    return stateId;
  }

  public void setStateId(int stateId) {
    this.stateId = stateId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public Entrant() {
  }

  public Entrant(int id, String fullName, String email, String city,
      String region, String schoolName, int stateId, int userId) {
    this.id = id;
    this.fullName = fullName;
    this.email = email;
    this.city = city;
    this.region = region;
    this.schoolName = schoolName;
    this.stateId = stateId;
    this.userId = userId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Entrant entrant = (Entrant) o;
    return id == entrant.id && stateId == entrant.stateId
        && userId == entrant.userId && Objects.equals(fullName,
        entrant.fullName) && Objects.equals(email, entrant.email)
        && Objects.equals(city, entrant.city)
        && Objects.equals(region, entrant.region)
        && Objects.equals(schoolName, entrant.schoolName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, fullName, email, city, region, schoolName, stateId,
        userId);
  }

  @Override
  public String toString() {
    return "Entrant{" +
        "id=" + id +
        ", fullName='" + fullName + '\'' +
        ", email='" + email + '\'' +
        ", city='" + city + '\'' +
        ", region='" + region + '\'' +
        ", schoolName='" + schoolName + '\'' +
        ", stateId=" + stateId +
        ", userId=" + userId +
        '}';
  }
}
