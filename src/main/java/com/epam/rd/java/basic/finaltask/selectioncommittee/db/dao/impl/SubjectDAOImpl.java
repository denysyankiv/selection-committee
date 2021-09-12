package com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.AbstractDAO;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.Faculty;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.Subject;
import com.epam.rd.java.basic.finaltask.selectioncommittee.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class SubjectDAOImpl implements AbstractDAO<Integer, Subject> {

  private static final Logger log = Logger.getLogger(SubjectDAOImpl.class);

  private static final String INSERT = "INSERT INTO subject"
      + "(subject_type) VALUE"
      + "(?)";
  private static final String DELETE = "DELETE FROM subject WHERE id = ?";
  private static final String FIND_BY_ID = "SELECT * FROM subject WHERE"
      + " id = ?";
  private static final String UPDATE = "UPDATE subject SET "
      + "subject_type=? WHERE id=?";
  private static final String FIND_ALL = "SELECT * FROM subject";

  private final Connection conn;

  public SubjectDAOImpl(Connection conn) {
    this.conn = conn;
  }

  @Override
  public List<Subject> getAll() throws DAOException {
    List<Subject> list = new ArrayList<>();
    try (PreparedStatement prst = conn.prepareStatement(FIND_ALL)) {

      ResultSet rs = prst.executeQuery(FIND_ALL);
      while (rs.next()) {
        list.add(new Subject(rs.getInt(1), rs.getInt(1)));
      }
    } catch (SQLException e) {
      log.error(e.getMessage());
      throw new DAOException(e.getMessage());
    }
    return list;
  }

  @Override
  public boolean update(Subject entity) throws DAOException {
    try (PreparedStatement prst = conn.prepareStatement(UPDATE)) {

      prst.setInt(1, entity.getId());
      prst.setInt(2, entity.getSubjectTypeId());
      prst.executeUpdate();
    } catch (SQLException e) {
      log.error(e.getMessage());
      return false;
    }
    return true;
  }

  @Override
  public boolean delete(Integer integer) throws DAOException {
    try (PreparedStatement prst = conn.prepareStatement(DELETE)) {
      prst.setInt(1, integer);
      return prst.execute();
    } catch (SQLException e) {
      log.error(e.getMessage());
      return false;
    }
  }

  @Override
  public boolean create(Subject entity) throws DAOException {
    try (PreparedStatement prst = conn.prepareStatement(INSERT)) {
      prst.setInt(1, entity.getId());
      prst.setInt(2, entity.getSubjectTypeId());
      prst.executeUpdate();
      return true;
    } catch (SQLException e) {
      log.error(e.getMessage());
    }
    return false;
  }

  @Override
  public Subject getById(Integer integer) throws DAOException {
    try (PreparedStatement prst = conn.prepareStatement(FIND_BY_ID)) {

      prst.setInt(1, integer);
      ResultSet rs = prst.executeQuery();
      rs.next();

      Subject s = new Subject();
      s.setId(rs.getInt(1));
      s.setSubjectTypeId(rs.getInt(2));
      return s;
    } catch (SQLException e) {
      log.error(e.getMessage());
    }
    return null;
  }
}
