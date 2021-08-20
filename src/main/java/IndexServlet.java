import com.epam.rd.java.basic.finaltask.selectioncommittee.db.dao.impl.FacultyDAOImpl;
import com.epam.rd.java.basic.finaltask.selectioncommittee.db.entity.Faculty;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class IndexServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");

    PrintWriter out = response.getWriter();
    FacultyDAOImpl facultyDAO = new FacultyDAOImpl();
    for(Faculty f: facultyDAO.findAllFaculties()) {
      out.println("<h2>" + f + "</h2>");
    }

  }

  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {

  }
}
