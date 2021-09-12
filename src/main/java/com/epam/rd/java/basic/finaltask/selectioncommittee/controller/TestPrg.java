package com.epam.rd.java.basic.finaltask.selectioncommittee.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/TestPrg")
public class TestPrg extends HttpServlet {

  private static int k = 0;
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    response.setContentType("text/html");
    String param = request.getParameter("ctr");



    PrintWriter out = response.getWriter();

    out.append("<form method='post'> <input type='text' name='ctr' /> <input " +
            "type='submit' />");
    out.append("</form>");
    out.append("<br>" + param + k++);
//    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  protected void doPost(HttpServletRequest request,
                        HttpServletResponse response)
          throws IOException {
    String param = request.getParameter("ctr");
    try{
      k += Integer.parseInt(param);
    } catch (NumberFormatException e) {
      e.getMessage();
    }

    response.sendRedirect("TestPrg");
  }
}
