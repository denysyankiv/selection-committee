package com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.Faculty;
import java.util.List;

public interface FacultyDAO {

  int insertFaculty(Faculty faculty);

  boolean deleteFaculty(int id);

  Faculty findFacultyById(int id);

  boolean updateFaculty(Faculty faculty);

  List<Faculty> findAllFaculties();
}
