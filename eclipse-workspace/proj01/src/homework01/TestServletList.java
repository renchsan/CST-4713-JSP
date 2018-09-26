// Matthew Rencher
// CST4713
// Servlet that generates a list of 4 random numbers

package homework01;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/** Simple servlet for testing. Generates HTML instead of plain
 *  text as with the HelloWorld servlet.
 */

@WebServlet("/list")
public class TestServletList extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    double num1 = Math.random();
    double num2 = Math.random();
    double num3 = Math.random();
    double num4 = Math.random();

    out.println
      ("<!DOCTYPE html>\n" +
       "<html>\n" +
       "<head><title>Random Number List</title></head>\n" +
       "<body bgcolor=\"#D3D3D3\">\n" +
       "<ul>" +
       "<li>" + num1 + "</li>" +
       "<li>" + num2 + "</li>" +
       "<li>" + num3 + "</li>" +
       "<li>" + num4 + "</li>" +
       "</ul>" +
       "<h1>List of 4 Random Numbers</h1>\n" +
       "</body></html>");
  }
}
