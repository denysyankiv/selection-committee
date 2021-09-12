package com.epam.rd.java.basic.finaltask.selectioncommittee.command;

import com.epam.rd.java.basic.finaltask.selectioncommittee.Path;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.DBManagerTomcatPool;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.impl.UserDAOImpl;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.impl.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import org.apache.log4j.Logger;

public class LoginCommand extends Command {

  private static final Logger log = Logger.getLogger(LoginCommand.class);
  @Override
  public String execute(HttpServletRequest request,
      HttpServletResponse response) throws IOException, ServletException {
    log.debug("Command starts");
    HttpSession session = request.getSession();


    String login = request.getParameter("login");
    log.trace("Request parameter: logging --> " + login);

    String password = request.getParameter("password");

    String errorMessage = null;
    String forward = Path.PAGE__ERROR_PAGE;

    if(login == null || password == null || login.isEmpty() || password.isEmpty()){
      errorMessage = "Login/password cannot be empty";
      request.setAttribute("errorMessage", errorMessage);
      log.error("errorMessage --> " + errorMessage);
      return forward;
    }

    User user = new UserDAOImpl(DBManagerTomcatPool.getInstance()
        .getConnection()).getByLogin(login);
    log.trace("Found in DB: user --> " + user);


    if(user==null || !password.equals(user.getPassword())){
      errorMessage = "Cannot find user with such login/password";
      request.setAttribute("errorMessage", errorMessage);
      log.error("errorMessage --> " + errorMessage);
      return forward;
    } else {
//      Role userRole = Role.getRole(user);
      String userRole = user.getType();
      log.trace("userRole --> " + userRole);


      if(userRole.equals("admin")){
        forward = Path.PAGE__ADMIN;
      }

      if(userRole.equals("entrant")){
        forward = Path.PAGE__ENTRANT;
      }

      session.setAttribute("user",user);
      log.trace("Set the session attribute: user --> " + user);

      session.setAttribute("userRole", userRole);
      log.trace("Set the session attribute: user --> " + user);

      log.info("User " + user + " logged as " + userRole.toString().toLowerCase());

//      String userLocaleName = user.getLocaleName();
//      log.trace("userLocalName --> " + userLocaleName);
//
//      if(userLocaleName != null && !userLocaleName.isEmpty()){
//        Config.set(session,"javax.servlet.jsp.jstl.fmt.locale", userLocaleName);
//
//        session.setAttribute("defaultLocale", userLocaleName);
//        log.trace("Set the session attribute: defaultLocale --> " + userLocaleName);
//
//        log.info("Locale for user: defaultLocale --> " + userLocaleName);
//      }

    }

    log.debug("Command finished");
    return forward;
  }
}
