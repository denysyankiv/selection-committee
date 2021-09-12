package com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.Faculty;
import java.sql.Connection;

public interface FactoryDAO {
  AbstractDAO<Integer, Faculty> createFacultyDAO(Connection connection);
  FacultyTranslationDAO createFacultyTranslationDAO(Connection connection);
  Connection createConnection();
}
