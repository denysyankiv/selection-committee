package com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.AbstractDAO;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.Entrant;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.Subject;
import com.epam.rd.java.basic.finaltask.selectioncommittee.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class EntrantDAOImpl implements AbstractDAO<Integer, Entrant> {

  private static final Logger log = Logger.getLogger(EntrantDAOImpl.class);

  private static final String INSERT = "INSERT INTO entrant"
      + "(full_name, email, city, region, school_name, state_id, user_id) VALUE"
      + "(?, ?, ?, ?, ?, ?, ?)";
  private static final String DELETE = "DELETE FROM entrant WHERE id = ?";
  private static final String FIND_BY_ID = "SELECT * FROM entrant WHERE"
      + " id = ?";
  private static final String UPDATE = "UPDATE entrant SET "
      + "full_name=?, email=?, city=?, region=?, school_name=?,state_id=?, user_id=? WHERE id=?";
  private static final String FIND_ALL = "SELECT * FROM entrant";

  private final Connection conn;

  public EntrantDAOImpl(Connection conn) {
    this.conn = conn;
  }

  @Override
  public List<Entrant> getAll() throws DAOException {
    List<Entrant> list = new ArrayList<>();
    try (PreparedStatement prst = conn.prepareStatement(FIND_ALL)) {

      ResultSet rs = prst.executeQuery(FIND_ALL);
      while (rs.next()) {
        list.add(new Entrant(rs.getInt(1),
            rs.getString(2), rs.getString(3), rs.getString(4),
            rs.getString(5), rs.getString(6), rs.getInt(7),
            rs.getInt(8)));
      }
    } catch (SQLException e) {
      log.error(e.getMessage());
      throw new DAOException(e.getMessage());
    }
    return list;
  }

  @Override
  public boolean update(Entrant entity) throws DAOException {
    try (PreparedStatement prst = conn.prepareStatement(UPDATE)) {

      prst.setInt(1, entity.getId());
      prst.setString(2, entity.getFullName());
      prst.setString(3, entity.getEmail());
      prst.setString(4, entity.getCity());
      prst.setString(5, entity.getRegion());
      prst.setString(6, entity.getSchoolName());

      prst.setInt(7, entity.getStateId());
      prst.setInt(8, entity.getUserId());
      prst.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
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
  public boolean create(Entrant entity) throws DAOException {
    try (PreparedStatement prst = conn.prepareStatement(INSERT)) {
      prst.setString(1, entity.getFullName());
      prst.setString(2, entity.getEmail());
      prst.setString(3, entity.getCity());
      prst.setString(4, entity.getRegion());
      prst.setString(5, entity.getSchoolName());
      prst.setInt(5, entity.getStateId());
      prst.setInt(6, entity.getUserId());
      prst.executeUpdate();
      return true;
    } catch (SQLException e) {
      log.error(e.getMessage());
    }
    return false;
  }

  @Override
  public Entrant getById(Integer integer) throws DAOException {
    try (PreparedStatement prst = conn.prepareStatement(FIND_BY_ID)) {

      prst.setInt(1, integer);
      ResultSet rs = prst.executeQuery();
      rs.next();

      Entrant entrant = new Entrant();
      entrant.setId(rs.getInt(1));
      entrant.setFullName(rs.getString(2));
      entrant.setEmail(rs.getString(3));
      entrant.setCity(rs.getString(4));
      entrant.setRegion(rs.getString(5));
      entrant.setSchoolName(rs.getString(5));
      entrant.setStateId(rs.getInt(6));
      entrant.setUserId(rs.getInt(7));
      return entrant;
    } catch (SQLException e) {
      log.error(e.getMessage());
    }
    return null;
  }


}
