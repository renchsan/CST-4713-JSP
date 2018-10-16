// Matthew Rencher
// CST4713
// Servlet that uses a loop to output a HTML table with 25 rows, 10 columns
// Each cell should be labeled with it's rowXcol

package homework01;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/looptable")
public class TestServletLoopTable extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    out.println
      ("<!DOCTYPE html>\n" +
       "<html>\n" +
       "<head><title>Table generated with Loop</title></head>\n" +
       "<body>\n" +
       "<h1></h1>\n");

     out.println("<table BORDER=1 CELLPADDING=5 CELLSPACING=1>");
     for(int rows = 1; rows <= 25; rows++){
    	 out.println("<tr>");
    	 for (int cols = 1; cols <= 10; cols++){
    		 out.print("<td>" + cols + "." + rows + "</td>");
    	 }
       out.println("</tr>");
      }
      out.println("</table>");

      out.println("</body></html>");
  }
}
