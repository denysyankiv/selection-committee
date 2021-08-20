package com.epam.rd.java.basic.finaltask.selectioncommittee.dto;

import java.util.List;

public class Examination {

  private class EntrantInfo {

    private long id;
    private String fullName;
    private Exam[] exams = new Exam[3];
  }

  private class Exam {

    private String name;
    private float value;
  }

  private List<EntrantInfo> entrantInfos;
  private Faculty faculty;
  private boolean finalized;

}
