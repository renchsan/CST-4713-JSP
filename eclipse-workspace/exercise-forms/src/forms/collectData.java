// Matthew Rencher
// CST4713
// Servlet that uses a loop to output a HTML table with 25 rows, 10 columns
// Each cell should be labeled with it's rowXcol

package forms;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import MyUtilities.ServletUtilities;

@SuppressWarnings("serial")
@WebServlet("/collectData")
public class collectData extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    out.println
      ("<!DOCTYPE html>\n" +
       "<html>\n" +
       "<head><title>Data Collect from Form page</title></head>\n" +
       "<body bgcolor=\"#008080\">\n" +
       "<h1>Collecting Data</h1>\n"
       + "<p>First Name = " + request.getParameter("firstName") + "<BR>\n"
       + "Last Name = " + request.getParameter("lastName") + "<BR>\n"
       + "</p>\n" + 
       ServletUtilities.footerString());
    out.println("</table>");
    out.println("</body></html>");
  }
  
  public void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
	  	doGet(request, response);
  	};
}
