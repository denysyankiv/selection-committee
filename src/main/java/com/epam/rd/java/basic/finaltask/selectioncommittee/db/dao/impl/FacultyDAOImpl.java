package com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.AbstractDAO;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.FacultyDAO;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.Faculty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class FacultyDAOImpl implements AbstractDAO<Integer, Faculty> {

  private static final Logger log = Logger.getLogger(FacultyDAOImpl.class);

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

  private final Connection conn;

  public FacultyDAOImpl(Connection connection) {
    this.conn = connection;
  }

  @Override
  public boolean create(Faculty faculty) {
    try (PreparedStatement stmt = conn.prepareStatement(INSERT_FACULTY)) {
      stmt.setInt(1, faculty.getFinByGovNumOfStudents());
      stmt.setInt(2, faculty.getCommercialStudents());
      stmt.executeUpdate();
      return true;
    } catch (SQLException e) {
      log.error(e.getMessage());
    }
    return false;
  }

  @Override
  public boolean delete(Integer id) {
    try (PreparedStatement stmt = conn.prepareStatement(DELETE_FACULTY)) {
      stmt.setInt(1, id);
      return stmt.execute();
    } catch (SQLException e) {
      log.error(e.getMessage());
      return false;
    }
  }

  @Override
  public Faculty getById(Integer id) {
    try (PreparedStatement stmt = conn.prepareStatement(FIND_BY_ID,
        Statement.RETURN_GENERATED_KEYS)) {

      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();
      rs.next();

      Faculty f = new Faculty();
      f.setId(rs.getInt(1));
      f.setFinByGovNumOfStudents(rs.getInt(2));
      f.setCommercialStudents(rs.getInt(3));

      return f;
    } catch (SQLException e) {
      log.error(e.getMessage());
    }
    return null;
  }

  @Override
  public boolean update(Faculty faculty) {
    try (PreparedStatement stmt = conn.prepareStatement(UPDATE)) {

      stmt.setInt(1, faculty.getFinByGovNumOfStudents());
      stmt.setInt(2, faculty.getCommercialStudents());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  @Override
  public List<Faculty> getAll() {
    List<Faculty> faculties = new ArrayList<>();
    try (Statement stmt = conn.createStatement()) {

      ResultSet rs = stmt.executeQuery(FIND_ALL);
      while (rs.next()) {
        faculties.add(new Faculty(
            rs.getInt(1)
            , rs.getInt(2)
            , rs.getInt(3)));
      }
    } catch (SQLException e) {
      log.error(e.getMessage());
    }
    return faculties;
  }
}
