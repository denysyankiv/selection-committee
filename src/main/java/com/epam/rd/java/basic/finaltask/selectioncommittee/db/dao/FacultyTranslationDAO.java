package com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.FacultyTranslation;


public interface FacultyTranslationDAO {
  int insertFacultyTranslation(FacultyTranslation facultyTranslation);

  boolean deleteFacultyTranslation(int facultyId, int languageId);

  FacultyTranslation findFacultyTranslationByFacultyIdAndLangId(int facultyId,
      int languageId);

  boolean updateFacultyTranslation(FacultyTranslation facultyTranslation);

}
