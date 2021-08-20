package com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.Faculty;
import java.util.List;

public interface FacultyDAO {

  int insertFaculty(Faculty faculty);

  boolean deleteFaculty(long id);

  Faculty findFacultyById(long id);

  boolean updateFaculty(Faculty faculty);

  List<Faculty> findAllFaculties();
}
