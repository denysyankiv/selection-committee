package com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.enums;

public enum EntrantState {
  UNLOCKED("unlocked"),LOCKED("locked");

  private String name;
  EntrantState(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  @Override
  public String toString() {
    return "EntrantState{" +
        "name='" + name + '\'' +
        '}';
  }
}
