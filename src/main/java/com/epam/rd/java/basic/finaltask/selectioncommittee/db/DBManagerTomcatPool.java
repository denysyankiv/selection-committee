package com.epam.rd.java.basic.finaltask.selectioncommittee.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public final class DBManagerTomcatPool {

  private static final Logger log = Logger.getLogger(DBManagerTomcatPool.class);
  private static final String INIT_CONTEXT_NAME = "java:/comp/env";
  private static final String ENV_CONTEXT_NAME = "jdbc/selection-committee-db";

  private static DBManagerTomcatPool instance;

  public static synchronized DBManagerTomcatPool getInstance() {
    if (instance == null) {
      instance = new DBManagerTomcatPool();
    }
    return instance;
  }

  public synchronized Connection getConnection() {
    DataSource ds;
    try {
      InitialContext initialContext = new InitialContext();
      Context envContext = (Context) initialContext.lookup(INIT_CONTEXT_NAME);
      ds = (DataSource) envContext.lookup(ENV_CONTEXT_NAME);

      return ds.getConnection();
    } catch (SQLException | NamingException e) {
      e.printStackTrace();
      log.error(e.getMessage());
    }
    return null;
  }


  public void commitAndClose(Connection connection) {
    try {
      connection.commit();
      connection.close();
    } catch (SQLException e) {
      log.error(e.getMessage());
    }
  }

  public void rollbackAndClose(Connection connection) {
    try {
      connection.rollback();
      connection.close();
    } catch (SQLException e) {
      log.error(e.getMessage());
    }
  }


}
