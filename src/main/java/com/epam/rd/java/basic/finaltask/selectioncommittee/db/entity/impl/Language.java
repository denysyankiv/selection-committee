package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.Entity;
import java.util.Objects;

public class Language implements Entity {
  private int id;
  private String name;

  public Language(){}
  public Language(String name){
    this.name = name;
  }

  public Language(int id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public String toString() {
    return "Language{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Language language = (Language) o;
    return id == language.id && Objects.equals(name, language.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
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
}
