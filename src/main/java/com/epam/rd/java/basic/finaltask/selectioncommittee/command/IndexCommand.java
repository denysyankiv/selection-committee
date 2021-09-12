package com.epam.rd.java.basic.finaltask.selectioncommittee.command;

import com.epam.rd.java.basic.finaltask.selectioncommittee.Path;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexCommand extends Command {

  @Override
  public String execute(HttpServletRequest request,
      HttpServletResponse response) throws IOException, ServletException {
    return Path.PAGE__LOGIN;
  }
}
