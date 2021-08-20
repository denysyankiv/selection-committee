package com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.DBManager;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.FacultyDAO;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.Faculty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FacultyDAOImpl implements FacultyDAO {

  private static final String INSERT_FACULTY = "INSERT INTO faculty"
      + "(students_fin_by_gov,commercial_students) VALUES "
      + "(?,?)";
  private static final String DELETE_FACULTY = "DELETE FROM faculty"
      + "WHERE id = ?";
  private static final String FIND_BY_ID = "SELECT TOP 1 * FROM faculty WHERE"
      + " id = ?";
  private static final String UPDATE = "UPDATE faculty SET "
      + "students_fin_by_gov=?, commercial_students WHERE id=?";
  private static final String FIND_ALL = "SELECT * FROM faculty";


  @Override
  public int insertFaculty(Faculty faculty) {
    return 0;
  }

  @Override
  public boolean deleteFaculty(long id) {
    return false;
  }

  @Override
  public Faculty findFacultyById(long id) {
    return null;
  }

  @Override
  public boolean updateFaculty(Faculty faculty) {
    return false;
  }

  @Override
  public List<Faculty> findAllFaculties() {
    List<Faculty> faculties = new ArrayList<>();
    try (Connection conn = DBManager.getConnection();) {
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(FIND_ALL);
      while (rs.next()) {
        faculties.add(new Faculty(
            rs.getInt(1)
            ,rs.getInt(2)
            ,rs.getInt(3)));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return faculties;
  }
}
