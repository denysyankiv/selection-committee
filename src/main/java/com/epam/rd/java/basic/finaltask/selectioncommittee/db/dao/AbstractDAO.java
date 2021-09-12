package com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao;

import com.epam.rd.java.basic.finaltask.selectioncommittee.exception.DAOException;
import java.util.List;

public interface AbstractDAO<K, E> {

  List<E> getAll() throws DAOException;

  boolean update(E entity) throws DAOException;

  boolean delete(K k) throws DAOException;

  boolean create(E entity) throws DAOException;

  E getById(K k) throws DAOException;
}
