package com.epam.rd.java.basic.finaltask.selectioncommittee.command;

import java.util.Map;
import java.util.TreeMap;
import org.apache.log4j.Logger;

public class CommandContainer {

  private static final Logger log = Logger.getLogger(CommandContainer.class);
  private static Map<String, Command> commandMap = new TreeMap<>();

  static {
    commandMap.put("index", new IndexCommand());
    commandMap.put("login", new LoginCommand());
//    commandMap.put("logout",new LogoutCommand());
    commandMap.put("noCommand", new NoCommand());

    // entrant
    commandMap.put("entrant", new EntrantCommand());
//    commandMap.put("enterSubjects",new EnterSubjectsCommand());
//    commandMap.put("registerOnFaculty", new RegisterOnFacultyCommand());

    // admin
    commandMap.put("editSubjects", new AdminCommand());
//    commandMap.put("editSubjects", new EditSubjectsCommand());
//    commandMap.put("editFaculties", new EditFacultiesCommand());
//    commandMap.put("editEntrantState", new EditEntrantStateCommand());
//    commandMap.put("editApplications", new EditApplicationsCommand());

    log.debug("Command container was successfully initialized");
    log.trace("Number of commands --> " + commandMap.size());
  }

  public static Command get(String commandName) {
    if (commandName == null || !commandMap.containsKey(commandName)) {
      log.trace("Command not found, name --> " + commandName);
      return commandMap.get("noCommand");
    }

    return commandMap.get(commandName);
  }
}
