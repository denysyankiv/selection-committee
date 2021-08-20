package com.epam.rd.java.basic.finaltask.selectioncommittee.controller;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.impl.FacultyDAOImpl;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.Faculty;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException {
    res.setContentType("text/html");

    PrintWriter out = res.getWriter();
    FacultyDAOImpl facultyDAO = new FacultyDAOImpl();
    for(Faculty f: facultyDAO.findAllFaculties()){
      out.println("<h2>"+f+"</h2>");
    }
  }
}
