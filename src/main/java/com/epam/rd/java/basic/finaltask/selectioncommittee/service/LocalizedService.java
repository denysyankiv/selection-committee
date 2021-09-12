package com.epam.rd.java.basic.finaltask.selectioncommittee.service;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.Language;
import java.util.List;

public interface LocalizedService<K, E> {

  boolean add(E entity, Language language);

  E getById(K id, Language language);

  boolean delete(K id);

  boolean update(E entity, Language language);

  List<E> getAll(Language language);
}
