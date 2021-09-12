package com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.AbstractDAO;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.User;
import com.epam.rd.java.basic.finaltask.selectioncommittee.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;

public class UserDAOImpl implements AbstractDAO<Integer, User> {

  private static final Logger log = Logger.getLogger(UserDAOImpl.class);

  private static final String INSERT = "INSERT INTO user"
      + "(login,password,role) VALUE"
      + "(?,?,?)";
  private static final String DELETE = "DELETE FROM user WHERE id = ?";
  private static final String FIND_BY_ID = "SELECT * FROM user WHERE"
      + " id = ?";
  private static final String UPDATE = "UPDATE user SET "
      + "login=?,password=?,role=? WHERE id=?";
  private static final String FIND_ALL = "SELECT * FROM user";
  private static final String FIND_BY_LOGIN = "SELECT * FROM user WHERE login=?";

  private final Connection conn;

  public UserDAOImpl(Connection conn) {
    this.conn = conn;
  }


  @Override
  public List<User> getAll() throws DAOException {
    return null;
  }

  @Override
  public boolean update(User entity) throws DAOException {
    return false;
  }

  @Override
  public boolean delete(Integer integer) throws DAOException {
    return false;
  }

  @Override
  public boolean create(User entity) throws DAOException {
    return false;
  }

  @Override
  public User getById(Integer integer) throws DAOException {
    return null;
  }

  public User getByLogin(String login) {
    try (PreparedStatement prstm = conn.prepareStatement(FIND_BY_LOGIN)) {
      prstm.setString(1, login);

      ResultSet resultSet = prstm.executeQuery();
      resultSet.next();

      return new User(
          resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
              resultSet.getString(4));

    } catch (SQLException e) {
      log.error(e.getMessage());
    }
    return null;
  }
}
