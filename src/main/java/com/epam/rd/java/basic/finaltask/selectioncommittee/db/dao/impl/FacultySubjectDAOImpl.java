package com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.AbstractDAO;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.FacultySubject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class FacultySubjectDAOImpl {

  private static final Logger log = Logger.getLogger(
      FacultySubjectDAOImpl.class);
  private static final String FIND_BY_F_ID_SUBJ_ID =
      "SELECT * FROM faculty_subject WHERE faculty_id=?,subject_id=? LIMIT 1";

  private final Connection conn;

  public FacultySubjectDAOImpl(Connection conn) {
    this.conn = conn;
  }

  public FacultySubject getByFacultyIdAndSubjectId(int facultyId, int subjectId) {
    try (PreparedStatement prst = conn.prepareStatement(FIND_BY_F_ID_SUBJ_ID)){
      prst.setInt(1,facultyId);
      prst.setInt(2,subjectId);

      ResultSet rs = prst.executeQuery();
      rs.next();

      FacultySubject facultySubject = new FacultySubject();
     // facultySubject.set

    } catch (SQLException e){
      log.error(e.getMessage());
    }
    return null;
  }
}
