package com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.DBManagerTomcatPool;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.Faculty;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FacultyDAOImplTest {

  private FacultyDAOImpl facultyDAO;
  private Faculty faculty;
  @Before
  public void setUp() throws Exception {
    facultyDAO = new FacultyDAOImpl(DBManagerTomcatPool.getInstance()
        .getConnection());
    faculty = new Faculty(1,10,5);
  }

  @After
  public void tearDown() throws Exception {
    facultyDAO = null;
  }

  @Test
  public void insertFaculty() {
//    facultyDAO.insertFaculty(faculty);

  }

  @Test
  public void deleteFaculty() {
  }

  @Test
  public void findFacultyById() {
  }

  @Test
  public void updateFaculty() {
  }

  @Test
  public void findAllFaculties() {
  }
}