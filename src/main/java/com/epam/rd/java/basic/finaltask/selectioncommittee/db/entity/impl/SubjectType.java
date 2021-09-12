package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.Entity;
import java.util.Objects;

public class SubjectType implements Entity {

  private int id;
  private String name;


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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubjectType that = (SubjectType) o;
    return id == that.id && Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    return "SubjectType{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
