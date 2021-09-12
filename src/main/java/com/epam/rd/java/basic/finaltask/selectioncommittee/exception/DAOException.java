package com.epam.rd.java.basic.finaltask.selectioncommittee.exception;

public class DAOException extends Exception{
  public DAOException(){
    super();
  }

  public DAOException(String message, Throwable cause){
    super(message, cause);
  }

  public DAOException(String message){
    super(message);
  }
}
