package com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.FacultyTranslationDAO;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.FacultyTranslation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class FacultyTranslationDAOImpl implements FacultyTranslationDAO {

  private static final Logger log =
      Logger.getLogger(FacultyTranslationDAOImpl.class);
  private static final String INSERT = "INSERT INTO faculty_translation VALUE"
      + " (?,?,?,?)";
  private static final String DELETE = "DELETE FROM faculty_translation WHERE"
      + " faculty_id = ? AND language_id=?";
  private static final String FIND_BY_FACULTY_TRANSLATION_ID_LANG_ID =
      "SELECT * FROM "
          + "faculty_translation WHERE faculty_id=? AND language_id=?";

  private static final String UPDATE =
      "UPDATE faculty_translation SET name=?, description=? WHERE "
          + "faculty_id =? AND language_id=? ";

  private final Connection connection;

  public FacultyTranslationDAOImpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public int insertFacultyTranslation(FacultyTranslation facultyTranslation) {
    try (PreparedStatement stmt = connection.prepareStatement(INSERT)) {
      stmt.setInt(1, facultyTranslation.getFacultyId());
      stmt.setInt(2, facultyTranslation.getLanguageId());
      stmt.setString(3, facultyTranslation.getName());
      stmt.setString(4, facultyTranslation.getDescription());

      return stmt.executeUpdate();

    } catch (SQLException e) {
      log.error(e.getMessage());
    }
    return 0;
  }

  @Override
  public boolean deleteFacultyTranslation(int facultyId, int languageId) {
    try (PreparedStatement stmt = connection.prepareStatement(DELETE)) {
      stmt.setInt(1,facultyId);
      stmt.setInt(2,languageId);

      stmt.executeUpdate();
      return true;
    } catch (SQLException e) {
      log.error(e.getMessage());
    }
    return false;
  }


  @Override
  public FacultyTranslation findFacultyTranslationByFacultyIdAndLangId(
      int facultyId, int languageId) {
    try (PreparedStatement stmt = connection.prepareStatement(
        FIND_BY_FACULTY_TRANSLATION_ID_LANG_ID)) {
      stmt.setInt(1, facultyId);
      stmt.setInt(2, languageId);

      ResultSet rs = stmt.executeQuery();
      rs.next();
      return new FacultyTranslation(rs.getInt(1),rs.getInt(2), rs.getInt(3),
          rs.getString(4), rs.getString(5));
    } catch (SQLException e) {
      log.error(e.getMessage());
    }
    return null;
  }

  @Override
  public boolean updateFacultyTranslation(
      FacultyTranslation facultyTranslation) {
    try (PreparedStatement stmt = connection.prepareStatement(UPDATE)) {
      stmt.setString(1, facultyTranslation.getName());
      stmt.setString(2, facultyTranslation.getDescription());

      stmt.setInt(3, facultyTranslation.getFacultyId());
      stmt.setInt(4, facultyTranslation.getLanguageId());
      stmt.executeUpdate();
      return true;
    } catch (SQLException e) {
      log.error(e.getMessage());
    }
    return false;
  }

}
