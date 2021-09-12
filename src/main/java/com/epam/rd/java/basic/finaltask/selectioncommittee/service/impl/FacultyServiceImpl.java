package com.epam.rd.java.basic.finaltask.selectioncommittee.service.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.FactoryDAO;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.FacultyDAO;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.FacultyTranslationDAO;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.impl.FactoryDAOImpl;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.impl.FacultyDAOImpl;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.Faculty;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.FacultyTranslation;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.Language;
import com.epam.rd.java.basic.finaltask.selectioncommittee.dto.FacultyDTO;
import com.epam.rd.java.basic.finaltask.selectioncommittee.service.LocalizedService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class FacultyServiceImpl implements
    LocalizedService<Integer, FacultyDTO> {

  private static final Logger log = Logger.getLogger(FacultyServiceImpl.class);

  private final FactoryDAOImpl factoryDAO;

  public FacultyServiceImpl() {
    factoryDAO = new FactoryDAOImpl();
  }

  @Override
  public boolean add(FacultyDTO facultyDTO, Language language) {

    try (Connection connection = factoryDAO.createConnection()) {
      FacultyDAOImpl facultyDAO = factoryDAO.createFacultyDAO(connection);
      FacultyTranslationDAO facultyTranslationDAO =
          factoryDAO.createFacultyTranslationDAO(connection);
      Faculty f = convertToFaculty(facultyDTO);
      FacultyTranslation fT = convertToFacultyTranslation(facultyDTO, language);
      facultyDAO.create(f);
      facultyTranslationDAO.insertFacultyTranslation(fT);
    } catch (SQLException e) {
      log.error(e.getMessage());
    }
    return false;
  }

  @Override
  public FacultyDTO getById(Integer id, Language language) {
    try (Connection connection = factoryDAO.createConnection()) {
      FacultyDAOImpl facultyDAO = factoryDAO.createFacultyDAO(connection);
      FacultyTranslationDAO facultyTranslationDAO =
          factoryDAO.createFacultyTranslationDAO(connection);
      Faculty faculty = facultyDAO.getById(id);
      FacultyTranslation facultyTranslation =
          facultyTranslationDAO.findFacultyTranslationByFacultyIdAndLangId(id,
              language.getId());
      return convertToFacultyDTO(faculty, facultyTranslation);
    } catch (SQLException e) {
      log.error(e.getMessage());
    }
    return null;
  }

  @Override
  public boolean delete(Integer id) {
    // on delete - cascade
    try (Connection connection = factoryDAO.createConnection()) {
      FacultyDAOImpl facultyDAO = factoryDAO.createFacultyDAO(connection);
      facultyDAO.delete(id);
      return true;
    } catch (SQLException e) {
      log.error(e.getMessage());
    }
    return false;
  }

  @Override
  public boolean update(FacultyDTO facultyDTO, Language language) {
    try (Connection connection = factoryDAO.createConnection()) {
      FacultyDAOImpl facultyDAO = factoryDAO.createFacultyDAO(connection);
      FacultyTranslationDAO facultyTranslationDAO =
          factoryDAO.createFacultyTranslationDAO(connection);

      Faculty f = convertToFaculty(facultyDTO);
      FacultyTranslation ft = convertToFacultyTranslation(facultyDTO, language);
      facultyDAO.update(f);
      facultyTranslationDAO.updateFacultyTranslation(ft);

    } catch (SQLException e) {
      log.error(e.getMessage());
    }
    return false;
  }

  @Override
  public List<FacultyDTO> getAll(Language language) {

    List<FacultyDTO> list = new ArrayList<>();
    try (Connection connection = factoryDAO.createConnection()) {
      FacultyDAOImpl facultyDAO = factoryDAO.createFacultyDAO(connection);
      FacultyTranslationDAO facultyTranslationDAO =
          factoryDAO.createFacultyTranslationDAO(connection);
      // exception
      for (Faculty f : facultyDAO.getAll()) {
        list.add(convertToFacultyDTO(f,
            facultyTranslationDAO.findFacultyTranslationByFacultyIdAndLangId(
                f.getId(), language.getId())));
      }


    } catch (SQLException e) {
      log.error(e.getMessage());
    }

    return list;
  }

  private static FacultyDTO convertToFacultyDTO(Faculty faculty,
      FacultyTranslation facultyTranslation) {
    FacultyDTO facultyDTO = new FacultyDTO();
    facultyDTO.setId(faculty.getId());
    facultyDTO.setName(facultyTranslation.getName());
    facultyDTO.setDescription(facultyTranslation.getDescription());
    facultyDTO.setFinByGovNumOfStudents(faculty.getFinByGovNumOfStudents());
    facultyDTO.setCommercialStudents(faculty.getCommercialStudents());
    return facultyDTO;
  }

  private static Faculty convertToFaculty(FacultyDTO facultyDTO) {
    return new Faculty(facultyDTO.getId(),
        facultyDTO.getFinByGovNumOfStudents(),
        facultyDTO.getCommercialStudents());
  }

  private static FacultyTranslation convertToFacultyTranslation(
      FacultyDTO facultyDTO,
      Language language) {
    return new FacultyTranslation(facultyDTO.getId(), language.getId(),
        facultyDTO.getName(), facultyDTO.getDescription());
  }
}
