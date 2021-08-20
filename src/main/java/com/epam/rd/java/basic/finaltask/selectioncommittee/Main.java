package com.epam.rd.java.basic.finaltask.selectioncommittee;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.FacultyDAO;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.impl.FacultyDAOImpl;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.Faculty;

public class Main {

  public static void main(String[] args) {
    FacultyDAO facultyDAO = new FacultyDAOImpl();
    for(Faculty f : facultyDAO.findAllFaculties()){
      System.out.println(f);
    }
  }
}
