package com.epam.rd.java.basic.finaltask.selectioncommittee.dto;

public class Faculty {
  private String name;
  private int capacityFinByGov;
  private int overrallCapacity;

  @Override
  public String toString() {
    return "Faculty{" +
        "name='" + name + '\'' +
        ", capacityFinByGov=" + capacityFinByGov +
        ", overrallCapacity=" + overrallCapacity +
        '}';
  }
}
