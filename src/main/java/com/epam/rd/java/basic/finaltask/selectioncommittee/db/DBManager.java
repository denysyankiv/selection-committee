package com.epam.rd.java.basic.finaltask.selectioncommittee.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

  // For docker network
  private static final String URL = "jdbc:mysql://db:3306/selection-committee-db";
  //  private static final String URL = "jdbc:mysql://localhost:3306/selection"
//      + "-committee-db";
  private static final String USER = "committee-root";
  private static final String PASS = "committee-root";

  public static Connection getConnection() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      return DriverManager.getConnection(URL, USER, PASS);
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }
}
