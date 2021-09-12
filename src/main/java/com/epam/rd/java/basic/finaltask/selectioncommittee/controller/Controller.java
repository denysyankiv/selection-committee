package com.epam.rd.java.basic.finaltask.selectioncommittee.controller;


import com.epam.rd.java.basic.finaltask.selectioncommittee.command.Command;
import com.epam.rd.java.basic.finaltask.selectioncommittee.command.CommandContainer;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

public class Controller extends HttpServlet {
  private static final Logger log = Logger.getLogger(Controller.class);

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    process(request,response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    process(request,response);
  }

  private void process(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    log.debug("Controller starts");

    // extract command name from the request
    String commandName = request.getParameter("command");
    log.trace("Request parameter: command --> " + commandName);

    // obtain command object by its name
    Command command = CommandContainer.get(commandName);
    log.trace("Obtained command --> " + command);

    // execute command and get forward address
    String forward = command.execute(request, response);
    log.trace("Forward address --> " + forward);

    log.debug("Controller finished, now go to forward address --> " + forward);

    // if the forward address is not null go to the address
    if (forward != null) {
      RequestDispatcher disp = request.getRequestDispatcher(forward);
      disp.forward(request, response);
    }
  }
}
