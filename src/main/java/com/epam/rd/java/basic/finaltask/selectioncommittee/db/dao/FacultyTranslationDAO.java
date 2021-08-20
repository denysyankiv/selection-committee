package com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.Faculty;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.FacultyTranslation;
import java.util.List;

public interface FacultyTranslationDAO {
  int insertFacultyTranslation(FacultyTranslation facultyTranslation);

  boolean deleteFacultyTranslation(int facultyId);

  FacultyTranslation findFacultyTranslationByFacultyId(int facultyId);
  FacultyTranslation findFacultyTranslationByFacultyIdAndLangId(int facultyId,
      int languageId);

  boolean updateFacultyTranslation(FacultyTranslation facultyTranslation);

  List<Faculty> findAllFaculties();
}
