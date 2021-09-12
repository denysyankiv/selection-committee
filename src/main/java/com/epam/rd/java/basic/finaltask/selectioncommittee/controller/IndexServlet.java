package com.epam.rd.java.basic.finaltask.selectioncommittee.controller;

import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.Language;
import com.epam.rd.java.basic.finaltask.selectioncommittee.dto.FacultyDTO;
import com.epam.rd.java.basic.finaltask.selectioncommittee.service.impl.FacultyServiceImpl;
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

    FacultyServiceImpl facultyService = new FacultyServiceImpl();


    for(FacultyDTO f: facultyService.getAll(new Language(1,"eng"))){
      out.println("<h2>"+f+"</h2>");
    }


    out.println(req.toString());
    out.println(res.toString());
  }
}
