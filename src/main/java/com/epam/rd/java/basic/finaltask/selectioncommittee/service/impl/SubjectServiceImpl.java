package com.epam.rd.java.basic.finaltask.selectioncommittee.service.impl;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.Language;
import com.epam.rd.java.basic.finaltask.selectioncommittee.dto.SubjectDTO;
import com.epam.rd.java.basic.finaltask.selectioncommittee.service.LocalizedService;
import java.util.List;

public class SubjectServiceImpl implements LocalizedService<Integer, SubjectDTO> {

  @Override
  public boolean add(SubjectDTO entity, Language language) {
    return false;
  }

  @Override
  public SubjectDTO getById(Integer id, Language language) {
    return null;
  }

  @Override
  public boolean delete(Integer id) {
    return false;
  }

  @Override
  public boolean update(SubjectDTO entity, Language language) {
    return false;
  }

  @Override
  public List<SubjectDTO> getAll(Language language) {
    return null;
  }
}
