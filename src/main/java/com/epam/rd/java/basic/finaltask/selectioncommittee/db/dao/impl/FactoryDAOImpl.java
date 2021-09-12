package com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.DBManagerTomcatPool;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.AbstractDAO;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.FactoryDAO;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.FacultyDAO;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.FacultyTranslationDAO;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.Faculty;
import java.sql.Connection;

public class FactoryDAOImpl implements FactoryDAO {

  @Override
  public FacultyDAOImpl createFacultyDAO(Connection connection) {
    return new FacultyDAOImpl(connection);
  }

  @Override
  public FacultyTranslationDAO createFacultyTranslationDAO(
      Connection connection) {
    return new FacultyTranslationDAOImpl(connection);
  }


  @Override
  public Connection createConnection() {
    return DBManagerTomcatPool.getInstance().getConnection();
  }
}
